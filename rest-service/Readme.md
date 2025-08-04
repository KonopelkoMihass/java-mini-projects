This is a tutorial project for "Building a RESTful Web Service" from this link:https://spring.io/guides/gs/rest-service#
It followed precisely the tutorial.

Afterward, the content from the https://spring.io/guides/tutorials/rest was implemented on top of it.

28.07.2025 - paused tutorial on "Building links into your REST API" part.
29.07.2025 - completed tutorial.
31.07.2025 - repeat implementation, step by step, noting all steps for self-learning.


Step 1: Create the object that contains data - Item
- Has a brand name
- Has its own name
- Has an ID
- Has a price before tax

Step 1.1: Implement Getters/Setters
Step 1.2: Override equals/hashCode/toString to deal with comparisons.

Step 2: prepare Item to be handled by Spring and RESTful API
Step 3: implement ItemRepository - an interface to perform CRUD on Item table in DB
Step 4: implement ItemModelAssembler and ItemController in parallel
- 