Coverage: 62.4%
# Inventory Management System

The Inventory Management System is able to track Customers, Items, Orders and Order Items (items within an order). Users are able to create, read, update and delete entries.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them

```
- Install Git Bash to push updates from your local respository to the Remote Github repository
  https://git-scm.com/downloads
  
- Install Eclipse IDE for Java
  https://www.eclipse.org/downloads/
  
- Install Java SE Development Kit 
  https://www.oracle.com/java/technologies/downloads/#java17
  
- Install Apache Maven for testing. Two dependencies are required JUnit and Mockito.
  https://maven.apache.org/download.cgi
  
- Install MySQL Community with Workbench to create and access databases.
  https://dev.mysql.com/downloads/installer/  
```

### Installing

How to download the IMS to your computer.

 #### Step one 
 Open a terminal console in the desired directory.
 Clone the repository using the ssh url of this repository.
 enter the following command in to the terminal: git clone git@github.com:sanchayarun/QA_IMS_Project.git

```
git clone git@github.com:sanchayarun/QA_IMS_Project.git
```
#### Step two
Go to your cloned directory then open and run files sql-schema.sql and sql-data.sql within the MySQL workbench to create the database on your local server.

#### Step Three
To setup the connection between the IMS and the database. Open db.properties in your eclipse IDE and change the db.username and db.password to what you set your MySQLlocal server username and password. 
```
db.url=jdbc:mysql://localhost:3306/ims
db.user="username here" - (default is = root)
db.password="password here" - (default is  = root)

```
#### Step Four
Open eclipse and open the QA_IMS_Project. right click on the Runner.java file and run as Java application. The program should start in the console. The console should look like this:
```
Welcome to the Inventory Management System!
Which entity would you like to use?
CUSTOMER: Information about customers
ITEM: Individual Items
ORDER: Purchases of items
ORDER_ITEM: Items in Order
STOP: To close the application


```
#### Step Five
You should be able to create, read, update and delete customers, orders, items and order_items. Just a note for deletion if want to delete a customer or order first delete the order_item linked to the order id then the order id followed by the customer id. deletion should occur in this order: order_item --> order --> customer.


## Running the tests

When all previou steps have been followed you can run tests. To run the tests right click on the project folder QA_IMS_Project, then click Coverage As JUnit test. This will run all the tests done in the project.

### Unit Tests 

Unit tests are performed on the smaller units of the application such as classes and methods.

```
@Test
	public void testCreate() {
		final Customer created = new Customer(2L, "chris", "perrins");
		assertEquals(created, DAO.create(created));
	}

	@Test
	public void testReadAll() {
		List<Customer> expected = new ArrayList<>();
		expected.add(new Customer(1L, "jordan", "harrison"));
		assertEquals(expected, DAO.readAll());
	}

```

### Integration Tests 
Integration tests are tests that involves disk access, application service and/or frameworks from the target application. So multiple components of the application are being used for the test and to check if they are all interacting properly.

These integration tests were done on CustomerController

```
@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}

	@Test
	public void testReadAll() {
		List<Customer> customers = new ArrayList<>();
		customers.add(new Customer(1L, "jordan", "harrison"));

		Mockito.when(dao.readAll()).thenReturn(customers);

		assertEquals(customers, controller.readAll());

		Mockito.verify(dao, Mockito.times(1)).readAll();
	}

```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [GitHub](https://github.com) for versioning.

## Authors
* **Sanchayan Arudchelvam - *Finished Product* - [SanchayArun](https://github.com/sanchayarun)
* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*

## Acknowledgments

* Charles Cairney and Tashfeen Arshad for their support throughout the project.
* Jordan Benbelaid - Trainer - [JordanBenBelaid](https://github.com/jordanbenbelaid)

