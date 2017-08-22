## UrbanClapPortal

Urban Clap Portal is a service provider website like sulekha.com. Suppose, someone needs some services like electrician or repair etc then, he/she can request for that service.

## Installation

Start with Wildfly, Webstorm, eclipse installed in ubuntu operating system.

1. First create a maven project using eclipse and import directory name as 'back-end'.
	#### You can get help from the link https://www.youtube.com/watch?v=BlkgrXb3L0c
2. Deploy the maven project in wildfly server.
	#### command to deploy:-
		mvn clean install; cp target/UrbanClapPortal-0.0.1-SNAPSHOT.war ~/wildfly-10.1.0.Final/standalone/deployments/
3. Create a angular cli project using webstorm and import directory name as 'front-end'.
4. Publish website on server.

## Usage

So, how do you use this? What can it do?

1. Login Page is common for both admins and users. There is provision for user registration in which it captures user details and at the end there is an option to select the user type admin / user.

2. On the Home Page the list of services. For admins, there is button available to add service type or delete service type on Home Page.

3. After adding the service, admins can add various representative details who will address the service request. This can be done by clicking on the particular service on home page and for admins, add service representative / list of service requests for that service type are shown.

4. Next home button another tab is displayed only for admins to see the list of services pending. They have a feature to accept or reject the request.

5. For Users only home page is displayed and they will have all services on that page itself. When they click on a particular service, they will be taken to Service request Page, in which it displays all the representatives sort by descending of price they offer.

6. Logout functionality is implemented.

