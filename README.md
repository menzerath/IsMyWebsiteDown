# Is My Website Down?

[![Join the chat at https://gitter.im/MarvinMenzerath/IsMyWebsiteDown](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/MarvinMenzerath/IsMyWebsiteDown?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
**"Is My Website Down?" periodically checks if your websites are reachable and notifies you if one of them is not.**

## How Does IMWD Work?
IMWD uses a simple algorithm to check your websites in two steps:

1. **Fetch Content**: IMWD tries to receive any content from the website (status-code needs to be `200 OK`). If this fails, IWMD tries to receive content from Google to check if there is a connection to the internet.
2. **Ping**: IWMD sends a ping to your website to check if "only" the webserver is down or the whole server.

### Configuration
When using the GUI your configuration is stored in a JSON-file inside your home-directory:

* Windows: `C:\Users\YourName\ismywebsitedown.json`
* Linux: `/home/YourName/ismywebsitedown.json`

You should _never_ edit this file manually, just use the GUI for this purpose. Otherwise you may break everything!  
Of course there is no reason why you shouldn't use the file for backup-purposes or using the same configuration on all your computers.

## Screenshots
<img src="https://raw.githubusercontent.com/MarvinMenzerath/IsMyWebsiteDown/master/doc/Screenshot1.png" alt="GUI" />
<img src="https://raw.githubusercontent.com/MarvinMenzerath/IsMyWebsiteDown/master/doc/Screenshot2.png" alt="Notification" width="50%" />
<img src="https://raw.githubusercontent.com/MarvinMenzerath/IsMyWebsiteDown/master/doc/Screenshot3.png" alt="Console" width="50%" />

## Download
* [**GitHub Releases**](https://github.com/MarvinMenzerath/IsMyWebsiteDown/releases)
* [**heise.de**](http://www.heise.de/download/is-my-website-down-1190272.html)

## Run
For a **graphical interface**, double click the downloaded file or do not add any arguments.

Otherwise use the following syntax:
```
java -jar IMWD.jar [URL] [INTERVAL] {ARG}
```

**Additional arguments**:
* `--once` ==> Runs only one check; interval will be ignored [(Example usage)](https://github.com/MarvinMenzerath/PiFace/blob/master/imwd.py)
* `--nolog` ==> Application won't produce a log-file
* `--help` ==> Gives you some help

### Examples
```
java -jar IMWD.jar
java -jar IMWD.jar http://website.com 30
java -jar IMWD.jar http://website.com 30 --nolog
java -jar IMWD.jar http://website.com 0 --once
```

### Quick Test Results
`OK`, `Ping Only`, `Not Reachable`, `No Connection`

## License
Copyright (C) 2012-2015 [Marvin Menzerath](https://menzerath.eu)

This program is free software: you can redistribute it and/or modify it under the terms of the GNU General Public License as published by the Free Software Foundation, either version 3 of the License, or any later version.

This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the [GNU General Public License](https://github.com/MarvinMenzerath/IsMyWebsiteDown/blob/master/LICENSE) for more details.
