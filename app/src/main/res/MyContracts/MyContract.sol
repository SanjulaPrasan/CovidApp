// SPDX-License-Identifier: MIT

pragma solidity 0.8.7;
contract covid {

    struct user{
        string MacAddress;
        int HealthStatus;
    }
    mapping(string => user) person;
    //user[] infectedPersons;
    string[] MacAddressList;
    int[] HealthStatusList;

    function addUser(string memory _macAddress,int _healthStatus) public {

        if(!inArray(_macAddress)){
            user memory myStruct;
            myStruct.MacAddress = _macAddress;
            myStruct.HealthStatus = _healthStatus;
            //infectedPersons.push(myStruct);
            MacAddressList.push(_macAddress);
            HealthStatusList.push(_healthStatus);
        }else{
            for(uint j = 0 ; j < MacAddressList.length; j++){
                if(compareStrings(MacAddressList[j],_macAddress)){
                    HealthStatusList[j] = _healthStatus;
                }
            }
        }
        person[_macAddress].MacAddress = _macAddress;
        person[_macAddress].HealthStatus = _healthStatus;
    }

    function inArray(string memory _macAddress) public view returns (bool) {
        if(getUserHealthStatus(_macAddress) == 1 || getUserHealthStatus(_macAddress) == 2 ){
            return true;
        }
        else {
            return false;
        }
    }

    function getUserAddress() public view returns(string[] memory ){
        return MacAddressList;
    }


    function getUserHealthStatus() public view returns(int[] memory){
        return HealthStatusList;
    }

    function getUsersCount() public view returns (uint) {
        return MacAddressList.length;
    }

    function getUserHealthStatus(string memory _macAddress)public view returns (int) {
        return person[_macAddress].HealthStatus;
    }

    function compareStrings(string memory a, string memory b) public pure returns (bool) {
        return (keccak256(abi.encodePacked((a))) == keccak256(abi.encodePacked((b))));
    }

}