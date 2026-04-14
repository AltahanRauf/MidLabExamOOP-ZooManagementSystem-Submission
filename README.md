# 🦁 Zoo Management System (Java OOP Project)
# Complete Documentation of Submission and Mistakes Highlights.

## 📌 Overview

This project implements a **Zoo Management System** using core **Object-Oriented Programming (OOP)** concepts in Java.

The system models:

* Animals (base class)
* Mammals and Birds (derived classes)
* Enclosures (aggregation)
* Zookeepers (association)

It also tracks:

* Total number of animals created (static variable)
* Feeding scores of animals

---

# ✅ What Was Done Correctly

Before discussing improvements, here are the parts that were implemented properly:

### ✔️ OOP Concepts Applied Correctly

* **Inheritance**:

  * `Mammal` and `Bird` correctly extend `Animal`
* **Aggregation**:

  * `Enclosure` uses `ArrayList<Animal>` to store multiple animals
* **Association**:

  * `Enclosure` has a `ZooKeeper` assigned

---

### ✔️ Static Variable Usage

* `totalAnimals` in `Animal` correctly counts all created objects
* Incremented inside constructor → correct behavior

```java
private static int totalAnimals = 0;

public Animal(String name, int age) {
    this.name = name;
    this.age = age;
    totalAnimals++;
}
```

---

### ✔️ Object Creation & Relationships

* Created:

  * 2 Mammals
  * 2 Birds
  * 2 Zookeepers
  * 2 Enclosures
* Assigned:

  * Animals → Enclosures
  * Zookeepers → Enclosures

---

### ✔️ Use of Getters and Constructors

* Proper constructors used
* Getter methods implemented

---

# ❌ Mistakes & Improvements (What I Should Have Done)

---

## 1. ❌ Incorrect Feeding Score Logic

### Problem

I used a loop that only returned the age instead of calculating:

> **Sum from 1 to age (recursive requirement)**

```java
public int calculateFeedingScore() {
    int score = 0;
    for (int i = 1; i <= age; i++) {
        score++;
    }
    return score;
}
```

### Why it's wrong

* It returns `age`
* NOT the cumulative sum

---

### ✅ Correct Recursive Implementation

```java
public int calculateFeedingScore() {
    return calculateFeedingScore(age);
}

private int calculateFeedingScore(int n) {
    if (n <= 0) return 0;
    return n + calculateFeedingScore(n - 1);
}
```

---

## 2. ❌ Missing `toString()` (Major Output Issue)

### Problem

I used:

```java
System.out.println(object.toString());
```

But did NOT override `toString()`.

### Result

Output looked like:

```
Mammal@23fc625e
ZooKeeper@4a574795
```

---

### 🔍 What `toString()` Does

* Default Java behavior prints:

  ```
  ClassName@MemoryAddress
  ```
* To display meaningful info → must override it

---

### ✅ Correct Example

#### In `Animal`:

```java
@Override
public String toString() {
    return "Animal{name='" + name + "', age=" + age + "}";
}
```

#### In `Mammal`:

```java
@Override
public String toString() {
    return "Mammal{name='" + getName() + "', age=" + getAge() +
           ", furColor='" + furColor + "'}";
}
```

#### In `ZooKeeper`:

```java
@Override
public String toString() {
    return "ZooKeeper{name='" + name + "', empId='" + empId + "'}";
}
```

---

## 3. ❌ Bird Class Issues

### Problems

#### ❌ 1. Wrong Class Name

* Used `Birds` instead of `Bird`

#### ❌ 2. Wingspan Not Assigned

```java
public Birds(String name, int age, double wingspan) {
    super(name, age);
}
```

* Missing:

```java
this.wingspan = wingspan;
```

---

### ✅ Correct Version

```java
public class Bird extends Animal {

    private double wingSpan;

    public Bird(String name, int age, double wingSpan) {
        super(name, age);
        this.wingSpan = wingSpan;
    }

    public double getWingSpan() {
        return wingSpan;
    }

    @Override
    public String toString() {
        return "Bird{name='" + getName() + "', age=" + getAge() +
               ", wingSpan=" + wingSpan + "}";
    }
}
```

---

## 4. ❌ Poor Encapsulation

### Problem

Some variables were not private:

```java
String name;
String empId;
double wingspan;
```

---

### ✅ Fix

```java
private String name;
private String empId;
private double wingSpan;
```

---

## 5. ❌ Enclosure Output Not Useful

### Problem

Printing enclosure:

```java
System.out.println(e1);
```

Result:

```
Enclosure@7adf9f5f
```

---

### ✅ Improved `toString()`

```java
@Override
public String toString() {
    String keeperName = (keeper == null) ? "None" : keeper.getName();

    return "Enclosure{ID='" + enclosureId +
           "', Keeper='" + keeperName +
           "', Animal Count=" + animals.size() + "}";
}
```

---

## 6. ❌ Naming Convention Issues

### Problems

* `Birds` → should be `Bird`
* `labexam` → should be `LabExam`
* `getwingspan()` → should be `getWingSpan()`

---

### ✅ Correct Convention

* Class → `PascalCase`
* Methods → `camelCase`

---

## 7. ❌ Unused Import

```java
import java.util.Scanner;
```

* Not used anywhere → should be removed

---

## 8. ❌ Output Did Not Match Requirements Fully

### Problem

* Output lacked readable details
* Feeding scores incorrect

---

### Expected Output Example

```
ZooKeeper{name='Alice Johnson', empId='ZK001'}

Mammal{name='Leo', age=5, furColor='Golden'}

Enclosure{ID='E01', Keeper='Alice Johnson', Animal Count=2}

Leo Feeding Score: 15
```

---

# 🔗 Object Relationships Explained

---

## 🧬 Inheritance

```java
Mammal → Animal
Bird → Animal
```

* Mammal **is an** Animal
* Bird **is an** Animal

---

## 📦 Aggregation

```java
ArrayList<Animal> animals;
```

* Enclosure **contains** Animals
* Animals exist independently

---

## 🔗 Association

```java
private ZooKeeper keeper;
```

* Enclosure is **linked** to ZooKeeper
* Not owned (independent objects)

---

# 📊 Final Learning Summary

### What I learned / should have improved:

* Recursive logic vs iterative logic
* Importance of overriding `toString()`
* Proper constructor initialization
* Clean OOP design with relationships
* Java naming conventions
* Encapsulation best practices

---

# 🚀 Final Verdict

The project structure was **correct and aligned with OOP principles**, but:

* Output clarity was missing due to `toString()`
* Feeding logic did not match requirement
* Minor design and naming issues existed

After fixing these, the project becomes:
✅ Fully functional
✅ Readable
✅ Exam-ready
✅ Conceptually correct

---

# 📌 Future Improvements

* Add polymorphism (override feeding logic per animal)
* Add UI (CLI menu system)
* Add file/database storage
* Add search/filter features

---

**Author:** Altahan Rauf
**Project Type:** Java OOP Lab / Exam Practice

---
