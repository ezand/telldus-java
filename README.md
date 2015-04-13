# telldus-java
Java wrapper around the Telldus CLI (tdtool). This is a work in progress, improvements are accepted through pull-requests :)

[![Build Status](https://travis-ci.org/ezand/telldus-java.svg?branch=master)](https://travis-ci.org/ezand/telldus-java)
[![Javadoc](http://javadoc-badge.appspot.com/org.ezand.telldus/telldus-core.svg?label=telldus-core)](http://ezand.org/javadocs/telldus-core/release/1.0/)
[![Javadoc](http://javadoc-badge.appspot.com/org.ezand.telldus/telldus-java.svg?label=telldus-java)](http://ezand.org/javadocs/telldus-java/release/1.0/)

# Build Tools
### Maven
    <dependency>
        <groupId>org.ezand.telldus</groupId>
        <artifactId>telldus-java</artifactId>
        <version>1.1</version>
    </dependency>

### Gradle
    runtime group: 'org.ezand.telldus', name: 'telldus-java', version: '1.1'

### Leiningen
    [org.ezand.telldus/telldus-java "1.1"]

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
See [telldus-core](https://github.com/ezand/telldus-core)
