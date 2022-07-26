package com.example.ui1.Blockchain;

import com.example.ui1.Blockchain.Contracts.MyContract;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.Web3ClientVersion;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.RawTransactionManager;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.DefaultGasProvider;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Blockchain {
    private final static String PRIVATE_KEY = "d5203cfb48fa6f7213fcdc1cc9e22754e071532d5fb21d8fd117644e162e2faf";
    private final static String URL = "https://rinkeby.infura.io/v3/3304584bca854a088fd65c1f7fd225ad";
    private final static BigInteger GAS_LIMIT = BigInteger.valueOf(6721975L);
    private final static BigInteger GAS_price = BigInteger.valueOf(20000000000L) ;

    private final static String DEPLOYED_ADDRESS = "0xfd6a246ee6a18f47b9d8c713a2bb12096d64c7f5";
    Web3j web3j;
    Credentials credentials;
    TransactionManager transactionManager;
    DefaultGasProvider defaultGasProvider;

    public Blockchain() {
        web3j= Web3j.build(new HttpService(URL));
        credentials = getCredentialsFromPrivateKey();
        transactionManager = new RawTransactionManager(web3j, credentials);
        defaultGasProvider = new DefaultGasProvider();
    }

    public void printWeb3jVersion(Web3j web3j){
        Web3ClientVersion web3jClientVersion = null;
        try {
            web3jClientVersion = web3j.web3ClientVersion().send();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(web3jClientVersion.getWeb3ClientVersion());
    }

    public Credentials getCredentialsFromPrivateKey(){
        return Credentials.create(PRIVATE_KEY);
    }

    public MyContract loadContractWithTransactionManager(String contractAddress , Web3j web3j, TransactionManager transactionManager, DefaultGasProvider defaultGasProvider){
        return MyContract.load(contractAddress,web3j,transactionManager,GAS_price,GAS_LIMIT);
    }
    public MyContract loadContractWithCredentials(String contractAddress , Web3j web3j, org.web3j.crypto.Credentials credentials, DefaultGasProvider defaultGasProvider){
        return MyContract.load(contractAddress,web3j,credentials,GAS_price,GAS_LIMIT);
    }

    public void sendData(String macAddress,int healthStatus){
        MyContract mycontract =loadContractWithCredentials(DEPLOYED_ADDRESS,web3j,credentials,defaultGasProvider);
        mycontract.addUser(macAddress,BigInteger.valueOf(healthStatus));
    }

    public List<String> getAddress(String macAddress, int healthStatus) throws Exception {
        MyContract mycontract =loadContractWithCredentials(DEPLOYED_ADDRESS,web3j,credentials,defaultGasProvider);
        return (List<String>) mycontract.getUserAddress().send();
    }
    public List<String> getHealthStatus(String macAddress, int healthStatus) throws Exception {
        MyContract mycontract =loadContractWithCredentials(DEPLOYED_ADDRESS,web3j,credentials,defaultGasProvider);
        return (List<String>) mycontract.getUserHealthStatus().send();
    }
}
