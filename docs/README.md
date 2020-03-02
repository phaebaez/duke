# Personal Assistant Togepi - User Guide

## Introduction

Personal Assistant Togepi (PAT) is for those who *prefer to use a desktop app for managing your tasks*. More importantly, PAT is *optimized for those who prefer to work with a Command Line Interface* (CLI), so if you can type fast, PAT can get your manage your tasks faster than traditional GUI apps. Interested? Jump to the **Quick Start** to get started. Enjoy!

## Quick Start

1. Ensure you have Java `11` or above installed in your Computer.
2. Download the latest `duke-0.2.jar` [here](https://github.com/phaebaez/duke/releases/tag/0.2)
3. Copy the file to the folder you want to use as the home folder for your Personal Assistant Togepi.
4. Double-click the file to start the app. The GUI should appear in a few seconds. 
![GitHub Logo](Ui.png)

5. Type the command in the command box and press <kbd>Enter</kbd> to execute it. E.g. typing *`help`* and pressing <kbd>Enter</kbd> will open the help window.

6. Some example commands you can try:

* `list` : lists all the tasks in the library 
* `todo` `n/homework`: adds a todo with the description `homework` to the library.
* `delete``3` : deletes the 3rd task shown in the current list
* `bye` : exits the app

7. Refer to **Features** for details of each command.

## Features 

### Feature 1

#### Add todos

Add tasks that the user needs *todo*.
Format: `todo n/DESCRIPTION`

Examples:

* `todo n/study for midterms` +
Returns a new *todo* with the description `study for midterms`. Displays the message `Togepi has found something and added it to her storage: [T] x study for midterms Now you have x tasks in your list`.

### Feature 2

#### Add deadlines

Add tasks that the user needs to complete by a certain *deadline*.
Format: `todo n/DESCRIPTION /by d/DATE`

Examples:

* `deadline n/assignment 0 /by 2/12/2020` +
Returns a new *deadline* with the description `assignment 0`. Displays the message `Togepi has found something and added it to her storage: [D] x assignment 0 (by Dec 2 2020) Now you have x tasks in your list`.

### Feature 3

#### Add event

Add *events* that the user needs to attend on a certain date.
Format: `todo n/DESCRIPTION /at d/DATE`

Examples:

* `event n/marathon /by 4/4/2020` +
Returns a new *event* with the description `marathon`. Displays the message `Togepi has found something and added it to her storage: [E] x marathon (at April 4 2020) Now you have x tasks in your list`.

