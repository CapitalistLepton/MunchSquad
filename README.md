# MunchSquad

A food ordering app that will also deliver your food. Customers will login to
the app and be able to order from several different restaurants and cuisines.
Once the customer has placed their order, the restaurant will be notified,
along with any available delivery drivers. When the food is ready, the delivery
drivers will then drive to the location given by the customer and deliver the
food.

## Running This Code

Simply clone the code from
[GitHub](https://github.com/CapitalistLepton/MunchSquad) or if you have the zip
file, open it and put the files in your AndroidStudioProjects directory.

## Testing This Code

To test this code the only changes that need to be made is to comment out the
StrictMode lines in DBLink.java

## Web API

This code makes use of a web API hosted on 
[heroku](https://munchsquad-api.herokuapp.com/) that serves as a database 
connection for the app. The API is written using Ruby on Rails and the source
code for the API can be found 
[here](https://github.com/CapitalistLepton/munchsquad-api).

The model of the API currently consists of

### Customer

#### Create a New Customer
To create a new customer `POST https://munchsquad-api.herokuapp.com/customers`
with the following paramaters:

* `String name` which is the customer's preferred full name
* `String password` which is the customer's plaintext password
* `String username` which is the customer'r chosen username

In the case that a customer chooses a username that has already been taken, the
server will respond with

```javascript
{error: "Username is already taken"}
```

Otherwise, the server will respond with the JSON of the customer's saved data.

#### Get a Customer's Information
To get a customer's information 
`GET https://munchsquad-api.herokuapp.com/customers/[username]` where 
`[username]` is the username of the customer that you're looking up.

If the customer exists, the server will respond with the JSON of the 
customer's saved data. The cusomer's password will be hashed using bcrypt.

#### Update a Customer's information
To update a customer's information
`PUT https://munchsquad-api.herokuapp.com/customers/[username]` where
`[username]` is the username of the customer that you're updating. Send the 
following parameters:

* `String name` which is the customer's preferred full name
* `String password` which is the customer's plaintext password

The server will respond with no content if the update is successful.

#### Delete a Customer
To delete a customer simply 
`DELETE https://munchsquad-api.herokuapp.com/customers/[username]` where
`[username]` is the username of the customer that you want to delete.

The server will respond with no content if the deletion is successful.
