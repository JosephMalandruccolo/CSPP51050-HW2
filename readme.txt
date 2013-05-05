Notes for grader:
Run the test classes


Homework 2 : Due May 7, 2013, 5:00 pm
Choose any one of the following problems:

Submitting:

Submit your assignments in a folder called HW2_MessageQueue or HW2_PipesAndFilter  to the subversion repository according to the directions on the syllabus page. Place all of your Homework 2 work into one folder. You will only be graded on your material within a reasonably labeled folder. Also, please include a README text file that contains the programming language you used. If you want to give the TAs/graders instructions on how to compile, run, or even understand your code, you can place that within the README as well.

From now on, each HW and Lab Deliverable should be submitted as described here and in HW 1. Each assignment (HW or Lab Deliverable) should have its own folder with its own README inside of it. Please ask for assistance if you have any questions

Problem 1: For this assignment you will implement a message queue in your language of choice.  There are two kinds of messages that can be sent to the Queue "QueryMsg" and "ReplyMsg". A user should be able to add messages to the Queue or remove messages from the Queue (assume the queue is strictly FIFO).

What you need to implement:

A class called MessageQueue that stores the messages it gets in a Vector (or similar class). The Vector class (already available in Java.util and the STL etc.) implements an array with dynamic size. The MessageQueue will need to implement methods to manipulate the queue (e.g. addMsg, popMsg, isEmpty etc.). 
A base class called Message and subclasses : QueryMsg and ReplyMsg. 
Test your program by using the message queue to send and receive a couple of messages.

 

Problem 2: You will implement a Pipes and Filter pattern for this assignment. A Filter typically either feeds input to the Pipe or reads from the Pipe and manipulates the data. In this case, there are two filters: the first one simply sends data into a pipe and the second filter reads off the pipe and converts the data to UPPER CASE.

What you need to implement:

Pipe class which accepts input from a filter. A Filter interface that is implemented by all filters. Two particular filters, the WriteFilter, and CapsFilter as described above.

A sample data file (top 30 NHL scorers) can be found here