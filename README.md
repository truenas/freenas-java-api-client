# <img src="https://www.freenas.org/wp-content/uploads/logo_flat_V2.png"/>


FreeNAS Java Client API
================================================


The idea of freenas-java-api-client is to allow to connect with FreeNAS/TrueNAS and being able to 
execute operations or fetch information from the system.

This will allow to interact with FreeNAS system by a Java application without know any details regarding
their API.

Moreover, the API is well described and examples are performed.


Another advantage of this library, is that it could keep consistency with different versions of 
API - so if the API change, you do not need to break your application.

The FreeNAS Java API Client supports FreeNAS API v1 and v2 (WIP).


Requirements
========================================================

The requirements to include this library is to have Java 1.8 or superior. 
The idea is not use modern Java syntax to make sure that it could run in legacy systems too.


How to use?
========================================================

The library is spited in three modules:

- accounts: accounts management 
- connectors: to configure the type of connection to the FreeNAS/TrueNAS API
- network: network management
- storage: storage management 

Example 
========================================================

``` 
       AuthenticationConnector auth = new AuthenticationConnector("root", "passwordForMyRoot");
       EndpointConnector ep = new EndpointConnector("http://10.20.20.176/", "http");
       GlobalConfigurationConnector gs = new GlobalConfigurationRestConnector(ep, auth);
       String hostname = gs.getHostname();
       System.out.println("The FreeNAS hostname is: " + hostname);
```


How to use the FreeNAS CLI?
========================================================

Add new dataset:
```
frenas-cli -user root -pass myPass -url http://my-own-nas -volume add zz05 -vname zz
```

Delete dataset:

```
frenas-cli -user root -pass myPass -url http://my-own-nas -volume delete zz/zz05 -vname zz
```


List Datasets from a Volume:

```
frenas-cli -user root -pass myPass -url http://my-own-nas4 -volume list all -vname zz
```


List alerts available:

```
frenas-cli -user root -pass myPass -url http://my-own-nas4 -alerts list all
```


List NFS shares:

```
frenas-cli -user root -pass myPass -url http://my-own-nas4 -share list all
```


Create the NFS Share:


```
frenas-cli -user root -pass myPass -url http://my-own-nas4 -share add /mnt/primary03 "NFSShareTest" sys
```


Delete the NFS Share:


```
frenas-cli -user root -pass myPass -url http://my-own-nas4 -share delete /mnt/primary03
```



How to configure conf/freenas.yml? 

The advantage of configure the yml file is that you will not need to pass the credentials and endpoint
everytime you want to run one command. 

```

freenas:
  username: <username>
  password: <pass>
  url:  http://freenas-address-url

```


DEVELOPERS - Do you want to contribute? 
========================================================

The project is organized in three modules:

- freenas-entities: the entities related with the object that exists in FreeNAS/TrueNAS and their serializers;
- freenas-java: the interface/API and the RESTful/WS connectors;
- freenas-cli: a command line interface to interact with FreeNAS.


