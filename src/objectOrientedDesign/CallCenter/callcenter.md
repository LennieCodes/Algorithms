# The problem
Imagine you have a call center with three levels of employees:
respondent, manager, and director. An incoming telephone call
must be first allocated to a respondent who is free. If the
respondent cannot handle the call, he or she must escalate the call to a manager. If the manager is not free
or not able to handle it, then the call should be escalated to
a director. 

Design the classes and data structures for this problem.
Implement a method dispatchCall() which assigns a call to
the first available employee. 

# Questions
1. What is the relationship between respondents, managers, and directors?
2. How many respondents per manager per director are there?
3. What happens if there are no respondents / managers / directors
available? 

```Java
// CallCenter.java
public class CallCenter {

  public ArrayList<Respondent> respondentList;
  public ArrayList<Manager> managerList;
  public ArrayList<Director> directorList;

  public CallCenter() {
    this.respondentList = new ArrayList<Respondent>();
    this.managerList = new ArrayList<Manager>();
    this.directorList = new ArrayList<Director>();
  }

  public void dispatchCall() {
    Employee handler; 
    // respondents get checked first.
    for (int i = 0; i < respondentList.size(); i++) {
      handler = respondentList.get(i);
      if (handler.isAvailable == true) {
        handler.isAvailable = false;
        return;
      }
    }
    // managers get checked second
    for (int i = 0; i < managerList.size(); i++) {
      handler = managerList.get(i);
      if (handler.isAvailable == true) {
        handler.isAvailable = false;
        return;
      }
    }

    // directors get checked last.
    for (int i = 0; i < directorList.size(); i++) {
      handler = directorList.get(i);
      if (handler.isAvailable == true) {
        handler.isAvailable = false;
        return;
      }
    }
  }
}
// Employee.java
public class Employee {
  // props are public for brevity
  public string name;
  public boolean isAvailable; 

  public Employee(string name) {
    this.name = name;
    this.isAvailable = true;
  }
}
// Respondent.java
public class Respondent extends Employee {
  
}

// Manager.java
public class Manager extends Employee {

}

// Director.java
public class Director extends Employee {

}

```