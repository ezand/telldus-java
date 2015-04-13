# telldus-java
Java wrapper around the Telldus CLI (tdtool). This is a work in progress, improvements are accepted through pull-requests :)

[![Build Status](https://travis-ci.org/ezand/telldus-java.svg?branch=master)](https://travis-ci.org/ezand/telldus-java)
[![Javadoc](http://javadoc-badge.appspot.com/org.ezand.telldus/telldus-java.svg?label=javadoc)](http://ezand.org/javadocs/telldus-java/release/1.0/)

# Build Tools
### Maven
    <dependency>
        <groupId>org.ezand.telldus</groupId>
        <artifactId>telldus-java</artifactId>
        <version>1.0</version>
    </dependency>

### Gradle
    runtime group: 'org.ezand.telldus', name: 'telldus-java', version: '1.0'

### Leiningen
    [org.ezand.telldus/telldus-java "1.0"]

# Features
### Functionality
<table>
  <tr>
    <th>Functionality</th>
    <th>Supported</th>
  </tr>
  <tr>
    <td>Switch on</td>
    <td><img src="static/yes.png"/></td>
  </tr>
  <tr>
    <td>Switch off</td>
    <td><img src="static/yes.png"/></td>
  </tr>
  <tr>
    <td>Dim to speified level</td>
    <td><img src="static/yes.png"/></td>
  </tr>
  <tr>
    <td>List devices</td>
    <td><img src="static/yes.png"/></td>
  </tr>
  <tr>
    <td>List sensors</td>
    <td><img src="static/yes.png"/></td>
  </tr>
  <tr>
    <td>Get device state (last sent command)</td>
    <td><img src="static/yes.png"/></td>
  </tr>
</table>

### Constants
<table>
  <tr>
    <th>Constant</th>
    <th>Supported</th>
  </tr>
  <tr>
    <td>LastSentCommand</td>
    <td>
        <img src="static/yes.png"/> ON<br />
        <img src="static/yes.png"/> OFF<br />
        <img src="static/yes.png"/> DIMMED<br />
    </td>
  </tr>
  <tr>
    <td>SensorProtocol</td>
    <td>
        <img src="static/yes.png"/> mandolyn<br />
        <img src="static/yes.png"/> fineoffset<br />
    </td>
  </tr>
  <tr>
    <td>SensorModel</td>
    <td>
        <img src="static/yes.png"/> temperature<br />
        <img src="static/yes.png"/> temperaturehumidity<br />
    </td>
  </tr>
</table>

# Domain
<table>
  <tr>
    <th>Name</th>
    <th>Description</th>
  </tr>
  <tr>
    <td>Device</td>
    <td>Holds device information, ex. info about switches and dimmers.</td>
  </tr>
  <tr>
    <td>Sensor</td>
    <td>Holds sensors information, ex. temperature and weather data</td>
  </tr>
  <tr>
    <td>State</td>
    <td>Holds the device state, ex. 'on' or 'off' for switches and the dim level (0-255) for dimmers.</td>
  </tr>
</table>
