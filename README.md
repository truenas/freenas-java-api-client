# <img src="https://www.freenas.org/wp-content/uploads/logo_flat_V2.png"/>


FreeNAS Java Client API
================================================


*freenas-java-api-client* connects FreeNAS/TrueNAS and allows the
execution of operations and retrival information from the system.

This will allow interaction with the system by a Java application without knowing
any details regarding the API.


The library seeks to maintains consistency with different versions of the
API - so that if the API changes then applications using the library will not break.

The FreeNAS Java API Client supports API v1 and v2 (WIP).


Requirements
========================================================

- Java 1.8 or higher
- Maven

The idea is not avoid a modern Java syntax to ensure it could run on legacy systems.

How to use?
========================================================

The library is split into four modules:

- accounts: account management 
- connectors: connection configuration of the FreeNAS/TrueNAS API
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

**freenas-cli -user USERNAME -pass PASSWORD -url NAS_URL -COMMAND ARGS**

Available commands:

- volume
- alerts
- share

Add new dataset:

```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -volume add zz05 -vname zz
```

Delete dataset:

```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -volume delete zz/zz05 -vname zz
```


List Datasets from a Volume:

```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -volume list all -vname zz
```


List alerts available:

```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -alerts list all
```


List NFS shares:

```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -share list all
```


Create the NFS Share:


```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -share add /mnt/primary03 "NFSShareTest" sys
```


Delete the NFS Share:


```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -share delete /mnt/primary03
```

List replication tasks:


```
freenas-cli -user USERNAME -pass PASSWORD -url http://NAS_IP -replication list all
```


How to configure conf/freenas.yml? 

Using the YML configuration file is preferred as you will not need to pass the
credentials and endpoint on every run. Copy freenas.yml.template to freenas.yml
and change the fields below to match the NAS in use.

```
freenas:
  username: <username>
  password: <pass>
  url:  https://freenas-address-url
  websocketsUri: wss://freenas-address-url/websocket
  websockets: true
```


DEVELOPERS - Do you want to contribute? 
========================================================

The project is organized into three modules:

- freenas-entities: the entities related with the object that exists in FreeNAS/TrueNAS and their serializers;
- freenas-java: the interface/API and the RESTful/WS connectors;
- freenas-cli: a command line interface to interact with FreeNAS.

To build, run "mvn clean install" or run "./build.sh" in the root directory,
which builds and then runs freenas-cli, assuming the conf file has been
configured correctly.
