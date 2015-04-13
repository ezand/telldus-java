# telldus-java
Java wrapper around the Telldus CLI (tdtool)

[![Build Status](https://travis-ci.org/ezand/telldus-java.svg?branch=master)](https://travis-ci.org/ezand/telldus-java)

# Maven
    <dependency>
        <groupId>org.ezand.telldus</groupId>
        <artifactId>telldus-java</artifactId>
        <version>1.0</version>
    </dependency>

# Features
## Functionality
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
    <td>Get sensor/device state (last sent command)</td>
    <td><img src="static/yes.png"/></td>
  </tr>
</table>

## Constants
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
