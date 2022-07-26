package com.example.ui1.Blockchain.Contracts;

import org.web3j.abi.TypeReference;
import org.web3j.abi.datatypes.Function;
import org.web3j.abi.datatypes.Type;
import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.RemoteCall;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.tx.Contract;
import org.web3j.tx.TransactionManager;
import org.web3j.tx.gas.ContractGasProvider;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version 3.6.0.
 */
public class MyContract extends Contract {
    private static final String BINARY = "608060405234801561001057600080fd5b50610897806100206000396000f3fe608060405234801561001057600080fd5b50600436106100625760003560e01c8063345f6ba7146100675780638fe95a1f1461008d578063a39fac12146100a2578063a4a1e263146100b7578063bed34bba146100bf578063fdd77a7f146100e2575b600080fd5b61007a61007536600461051f565b6100f5565b6040519081526020015b60405180910390f35b6100a061009b36600461055c565b61011f565b005b6100aa6102f2565b60405161008491906105d1565b60015461007a565b6100d26100cd36600461065b565b6103ed565b6040519015158152602001610084565b6100d26100f036600461051f565b610446565b6000808260405161010691906106bf565b9081526020016040518091039020600101549050919050565b61012882610446565b610198576040805180820190915282815260208101829052600180548082018255600091909152815182916002027fb10e2d527612073b26eecdfd717e6a320cf44b4afac2b0732d9fcbe2b7fa0cf6019081906101859082610764565b506020820151816001015550505061029e565b60005b60015481101561029c5761025b600182815481106101bb576101bb610824565b906000526020600020906002020160000180546101d7906106db565b80601f0160208091040260200160405190810160405280929190818152602001828054610203906106db565b80156102505780601f1061022557610100808354040283529160200191610250565b820191906000526020600020905b81548152906001019060200180831161023357829003601f168201915b5050505050846103ed565b1561028a57816001828154811061027457610274610824565b9060005260206000209060020201600101819055505b806102948161083a565b91505061019b565b505b816000836040516102af91906106bf565b908152604051908190036020019020906102c99082610764565b50806000836040516102db91906106bf565b908152604051908190036020019020600101555050565b60606001805480602002602001604051908101604052809291908181526020016000905b828210156103e45783829060005260206000209060020201604051806040016040529081600082018054610349906106db565b80601f0160208091040260200160405190810160405280929190818152602001828054610375906106db565b80156103c25780601f10610397576101008083540402835291602001916103c2565b820191906000526020600020905b8154815290600101906020018083116103a557829003601f168201915b5050505050815260200160018201548152505081526020019060010190610316565b50505050905090565b60008160405160200161040091906106bf565b604051602081830303815290604052805190602001208360405160200161042791906106bf565b6040516020818303038152906040528051906020012014905092915050565b6000610451826100f5565b600114806104675750610463826100f5565b6002145b1561047457506001919050565b506000919050565b634e487b7160e01b600052604160045260246000fd5b600082601f8301126104a357600080fd5b813567ffffffffffffffff808211156104be576104be61047c565b604051601f8301601f19908116603f011681019082821181831017156104e6576104e661047c565b816040528381528660208588010111156104ff57600080fd5b836020870160208301376000602085830101528094505050505092915050565b60006020828403121561053157600080fd5b813567ffffffffffffffff81111561054857600080fd5b61055484828501610492565b949350505050565b6000806040838503121561056f57600080fd5b823567ffffffffffffffff81111561058657600080fd5b61059285828601610492565b95602094909401359450505050565b60005b838110156105bc5781810151838201526020016105a4565b838111156105cb576000848401525b50505050565b60006020808301818452808551808352604092508286019150828160051b87010184880160005b8381101561064d57603f1989840301855281518051878552805180898701526060610628828289018d86016105a1565b928a0151868b015296890196601f01601f1916909401019250908601906001016105f8565b509098975050505050505050565b6000806040838503121561066e57600080fd5b823567ffffffffffffffff8082111561068657600080fd5b61069286838701610492565b935060208501359150808211156106a857600080fd5b506106b585828601610492565b9150509250929050565b600082516106d18184602087016105a1565b9190910192915050565b600181811c908216806106ef57607f821691505b60208210810361070f57634e487b7160e01b600052602260045260246000fd5b50919050565b601f82111561075f57600081815260208120601f850160051c8101602086101561073c5750805b601f850160051c820191505b8181101561075b57828155600101610748565b5050505b505050565b815167ffffffffffffffff81111561077e5761077e61047c565b6107928161078c84546106db565b84610715565b602080601f8311600181146107c757600084156107af5750858301515b600019600386901b1c1916600185901b17855561075b565b600085815260208120601f198616915b828110156107f6578886015182559484019460019091019084016107d7565b50858210156108145787850151600019600388901b60f8161c191681555b5050505050600190811b01905550565b634e487b7160e01b600052603260045260246000fd5b60006001820161085a57634e487b7160e01b600052601160045260246000fd5b506001019056fea2646970667358221220606d1fd3aa3cee79553817ca15222b8271c9bd16d1682c0483e4555f51eb8df564736f6c634300080f0033";

    public static final String FUNC_ADDUSER = "addUser";

    public static final String FUNC_COMPARESTRINGS = "compareStrings";

    public static final String FUNC_GETUSERADDRESS = "getUserAddress";

    public static final String FUNC_GETUSERHEALTHSTATUS = "getUserHealthStatus";

    public static final String FUNC_GETUSERSCOUNT = "getUsersCount";

    public static final String FUNC_INARRAY = "inArray";

    @Deprecated
    protected MyContract(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected MyContract(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected MyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected MyContract(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public RemoteCall<TransactionReceipt> addUser(String _macAddress, BigInteger _healthStatus) {
        final Function function = new Function(
                FUNC_ADDUSER, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_macAddress), 
                new org.web3j.abi.datatypes.generated.Int256(_healthStatus)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> compareStrings(String a, String b) {
        final Function function = new Function(
                FUNC_COMPARESTRINGS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(a), 
                new org.web3j.abi.datatypes.Utf8String(b)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getUserAddress() {
        final Function function = new Function(
                FUNC_GETUSERADDRESS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getUserHealthStatus(String _macAddress) {
        final Function function = new Function(
                FUNC_GETUSERHEALTHSTATUS, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_macAddress)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getUserHealthStatus() {
        final Function function = new Function(
                FUNC_GETUSERHEALTHSTATUS, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> getUsersCount() {
        final Function function = new Function(
                FUNC_GETUSERSCOUNT, 
                Arrays.<Type>asList(), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public RemoteCall<TransactionReceipt> inArray(String _macAddress) {
        final Function function = new Function(
                FUNC_INARRAY, 
                Arrays.<Type>asList(new org.web3j.abi.datatypes.Utf8String(_macAddress)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public static RemoteCall<MyContract> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyContract.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyContract> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyContract.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<MyContract> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(MyContract.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<MyContract> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(MyContract.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    @Deprecated
    public static MyContract load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyContract(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static MyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new MyContract(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static MyContract load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new MyContract(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static MyContract load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new MyContract(contractAddress, web3j, transactionManager, contractGasProvider);
    }
}
