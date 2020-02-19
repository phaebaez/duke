# User Guide

## Features 

### Feature 1 
Able to add tasks of various types 

## Usage
For the user to add tasks that the user needs **todo**, tasks that needs to be completed by a certain **deadline**, or **events** that the user needs to attend on a certain date. 

### `Keyword` - Describe action
* '***todo***' allows users to add todos. 

* '***deadline***' allows users to add deadlines.

* '***event***' allows users to add events.

### Describe action and its outcome.
Adding **todos/deadline/events** will appear in the user's list of tasks. A message should appear to confirm that the task has been added. If the user is still uncertain, the user can check by using the command '*list*' to see if the task has been added. 

### Example of usage: 
`keyword (optional arguments)`

* ***todo** study math*

* ***deadline** study for test /by 2/11/2020*

* ***event** marathon /at 4/4/2020*

### Expected outcome:
* ***todo** study math* should display the message *Togepi has found something and added it to her storage: [T] x study math Now you have x tasks in your list*.

* ***deadline** study for test /by 2/11/2020* should display the message *Togepi has found something and added it to her storage: [D] x study for test (by Dec 2 2020) Now you have x tasks in your list*.

* ***event** study math* should display the message *Togepi has found something and added it to her storage: [E] x marathon (at April 4 2020) Now you have x tasks in your list*.

For a visual representation, refer to the folder *src/main/resource/images*. The folder should contain 2 images labelled *add task pt 1* and *add task pt 2*. 
