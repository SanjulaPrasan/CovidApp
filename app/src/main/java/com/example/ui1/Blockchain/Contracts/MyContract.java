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
    private static final String BINARY = "608060405234801561001057600080fd5b50610d4e806100206000396000f3fe608060405234801561001057600080fd5b506004361061007d5760003560e01c8063a4a1e2631161005b578063a4a1e263146100ec578063bed34bba1461010a578063ebc3eee81461013a578063fdd77a7f146101585761007d565b8063345f6ba7146100825780638fe95a1f146100b2578063a0f26c72146100ce575b600080fd5b61009c600480360381019061009791906106b5565b610188565b6040516100a991906109ed565b60405180910390f35b6100cc60048036038101906100c791906106fe565b6101b2565b005b6100d66103a3565b6040516100e3919061098e565b60405180910390f35b6100f46103fb565b6040516101019190610a08565b60405180910390f35b610124600480360381019061011f919061075a565b610408565b60405161013191906109d2565b60405180910390f35b610142610461565b60405161014f91906109b0565b60405180910390f35b610172600480360381019061016d91906106b5565b61053a565b60405161017f91906109d2565b60405180910390f35b600080826040516101999190610977565b9081526020016040518091039020600101549050919050565b6101bb8261053a565b610245576101c7610573565b8281600001819052508181602001818152505060018390806001815401808255809150506001900390600052602060002001600090919091909150908051906020019061021592919061058d565b50600282908060018154018082558091505060019003906000526020600020016000909190919091505550610343565b60005b600180549050811015610341576103056001828154811061026c5761026b610c7e565b5b90600052602060002001805461028190610b74565b80601f01602080910402602001604051908101604052809291908181526020018280546102ad90610b74565b80156102fa5780601f106102cf576101008083540402835291602001916102fa565b820191906000526020600020905b8154815290600101906020018083116102dd57829003601f168201915b505050505084610408565b1561032e57816002828154811061031f5761031e610c7e565b5b90600052602060002001819055505b808061033990610bd7565b915050610248565b505b816000836040516103549190610977565b9081526020016040518091039020600001908051906020019061037892919061058d565b508060008360405161038a9190610977565b9081526020016040518091039020600101819055505050565b606060028054806020026020016040519081016040528092919081815260200182805480156103f157602002820191906000526020600020905b8154815260200190600101908083116103dd575b5050505050905090565b6000600180549050905090565b60008160405160200161041b9190610977565b60405160208183030381529060405280519060200120836040516020016104429190610977565b6040516020818303038152906040528051906020012014905092915050565b60606001805480602002602001604051908101604052809291908181526020016000905b828210156105315783829060005260206000200180546104a490610b74565b80601f01602080910402602001604051908101604052809291908181526020018280546104d090610b74565b801561051d5780601f106104f25761010080835404028352916020019161051d565b820191906000526020600020905b81548152906001019060200180831161050057829003601f168201915b505050505081526020019060010190610485565b50505050905090565b6000600161054783610188565b148061055b5750600261055983610188565b145b15610569576001905061056e565b600090505b919050565b604051806040016040528060608152602001600081525090565b82805461059990610b74565b90600052602060002090601f0160209004810192826105bb5760008555610602565b82601f106105d457805160ff1916838001178555610602565b82800160010185558215610602579182015b828111156106015782518255916020019190600101906105e6565b5b50905061060f9190610613565b5090565b5b8082111561062c576000816000905550600101610614565b5090565b600061064361063e84610a48565b610a23565b90508281526020810184848401111561065f5761065e610ce1565b5b61066a848285610b32565b509392505050565b60008135905061068181610d01565b92915050565b600082601f83011261069c5761069b610cdc565b5b81356106ac848260208601610630565b91505092915050565b6000602082840312156106cb576106ca610ceb565b5b600082013567ffffffffffffffff8111156106e9576106e8610ce6565b5b6106f584828501610687565b91505092915050565b6000806040838503121561071557610714610ceb565b5b600083013567ffffffffffffffff81111561073357610732610ce6565b5b61073f85828601610687565b925050602061075085828601610672565b9150509250929050565b6000806040838503121561077157610770610ceb565b5b600083013567ffffffffffffffff81111561078f5761078e610ce6565b5b61079b85828601610687565b925050602083013567ffffffffffffffff8111156107bc576107bb610ce6565b5b6107c885828601610687565b9150509250929050565b60006107de83836108e0565b60208301905092915050565b60006107f683836108fe565b905092915050565b600061080982610a99565b6108138185610ad4565b935061081e83610a79565b8060005b8381101561084f57815161083688826107d2565b975061084183610aba565b925050600181019050610822565b5085935050505092915050565b600061086782610aa4565b6108718185610ae5565b93508360208202850161088385610a89565b8060005b858110156108bf57848403895281516108a085826107ea565b94506108ab83610ac7565b925060208a01995050600181019050610887565b50829750879550505050505092915050565b6108da81610b12565b82525050565b6108e981610b1e565b82525050565b6108f881610b1e565b82525050565b600061090982610aaf565b6109138185610af6565b9350610923818560208601610b41565b61092c81610cf0565b840191505092915050565b600061094282610aaf565b61094c8185610b07565b935061095c818560208601610b41565b80840191505092915050565b61097181610b28565b82525050565b60006109838284610937565b915081905092915050565b600060208201905081810360008301526109a881846107fe565b905092915050565b600060208201905081810360008301526109ca818461085c565b905092915050565b60006020820190506109e760008301846108d1565b92915050565b6000602082019050610a0260008301846108ef565b92915050565b6000602082019050610a1d6000830184610968565b92915050565b6000610a2d610a3e565b9050610a398282610ba6565b919050565b6000604051905090565b600067ffffffffffffffff821115610a6357610a62610cad565b5b610a6c82610cf0565b9050602081019050919050565b6000819050602082019050919050565b6000819050602082019050919050565b600081519050919050565b600081519050919050565b600081519050919050565b6000602082019050919050565b6000602082019050919050565b600082825260208201905092915050565b600082825260208201905092915050565b600082825260208201905092915050565b600081905092915050565b60008115159050919050565b6000819050919050565b6000819050919050565b82818337600083830152505050565b60005b83811015610b5f578082015181840152602081019050610b44565b83811115610b6e576000848401525b50505050565b60006002820490506001821680610b8c57607f821691505b60208210811415610ba057610b9f610c4f565b5b50919050565b610baf82610cf0565b810181811067ffffffffffffffff82111715610bce57610bcd610cad565b5b80604052505050565b6000610be282610b28565b91507fffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff821415610c1557610c14610c20565b5b600182019050919050565b7f4e487b7100000000000000000000000000000000000000000000000000000000600052601160045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052602260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052603260045260246000fd5b7f4e487b7100000000000000000000000000000000000000000000000000000000600052604160045260246000fd5b600080fd5b600080fd5b600080fd5b600080fd5b6000601f19601f8301169050919050565b610d0a81610b1e565b8114610d1557600080fd5b5056fea2646970667358221220583c0b2e5180b57d86a252b47b6180506420684d30b47a4db0e8837d712c238664736f6c63430008070033";

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
