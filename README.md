# Matala1_Observer
Matala 1 in Object-oriented programming
# Path to files:
OOP.Assignment1 -> src -> main -> java -> observer  <br />
OOP.Assignment1 -> src -> test

## Data Base
We use a "Linked List" to save Admin's members, each Admin has his linked list with the data.  <br />
Admin has Stringbuilder that helps him to edit his messages (string type) and send them to all his members that registered to him. <br />
Use of StringBuilder is more efficient than use a simple String beacuse if we will want create many edites to the string it will ask to more memory if we will use a String and not StringBuilder.

## Algoritem
We use a loop that runs in a Linked list and updates her user in each iteration of the loop.

## How to use ?
Take all the files in a observer folder from the PATH .  <br />
Create an Admin:  <br />
```
  GroupAdmin "admin_name" = new GroupAdmin();
```

Create an Admin's member:  <br />
```
  ConcreteMember "member_name" = new ConcreteMember("admin_name");
  // ...     (does not matter the number of members)
```
Send messages to Admin's member:  <br />
```
	("admin_name").(ACTION);
	// ACTION: append / delete / insert / undo
```
If you want to add/delete a member:  <br />
```
	("admin_name").register("member_name");
	// same for unregister
```
