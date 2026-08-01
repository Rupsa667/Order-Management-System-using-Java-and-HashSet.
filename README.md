# 📦 Order Management System (Java + HashSet)

A console-based **Item Management System** built in core Java, demonstrating OOP design, custom checked exceptions, the Comparator/Strategy pattern for sorting, and Lombok for boilerplate reduction. Items are stored in-memory using a `LinkedHashSet` — no database required.

> **Note:** Despite the project name, the current version manages generic `Item` records (id, name, price) rather than customer orders — a solid foundation that can be extended into a full order-processing system.

![Java](https://img.shields.io/badge/Java-25-orange)
![Maven](https://img.shields.io/badge/Build-Maven-blue)
![Lombok](https://img.shields.io/badge/Lombok-1.18.42-red)
![Status](https://img.shields.io/badge/Status-Completed-brightgreen)

---

## 📌 Overview

This project simulates basic inventory/item operations through a simple text menu in the terminal. It's designed to practice:

- Interfaces and implementation classes (`OrderOperations` → `Order`)
- Custom checked exceptions for domain-specific error handling
- The `Comparator` interface for pluggable sorting strategies
- Collections (`Set` / `LinkedHashSet`) for in-memory data storage
- Lombok annotations (`@Getter`, `@Setter`, `@NoArgsConstructor`, `@AllArgsConstructor`, `@ToString`)

---

## 🚀 Features

✅ Add new items (with duplicate ID protection)
✅ Display all items
✅ Update an existing item's name and price
✅ Remove an item by ID
✅ Search for an item by name
✅ Sort all items by **name** or **price**
✅ Graceful error handling via custom exceptions
✅ Clean exit

---

## 🛠️ Tech Stack

| Technology | Purpose                     |
| ---------- | ---------------------------- |
| Java 25    | Core language                |
| Maven      | Build & dependency management |
| Lombok     | Boilerplate reduction (getters/setters/constructors) |

---

## 📂 Project Structure

```
src/main/java/com/example
│
├── exception
│   ├── DuplicateItemException.java
│   └── ItemNotFoundException.java
│
├── model
│   └── Item.java
│
├── service
│   ├── OrderOperations.java
│   └── impl
│       └── Order.java
│
├── sorting
│   ├── SortByName.java
│   └── SortByPrice.java
│
└── Main.java
```

---

## 🧩 Design Overview

- **`Item`** — a simple model (`itemId`, `itemName`, `price`) with Lombok-generated getters, setters, constructors, and `toString()`.
- **`OrderOperations`** — interface defining the contract: add, view, update, delete, search, and retrieve all items.
- **`Order`** — implements `OrderOperations` using a `LinkedHashSet<Item>` to preserve insertion order while storing items. Duplicate item IDs are rejected via manual ID comparison before insertion.
- **`SortByName`** / **`SortByPrice`** — separate `Comparator<Item>` implementations, allowing the sort logic to be swapped independently of the collection code (Strategy pattern).
- **`DuplicateItemException`** / **`ItemNotFoundException`** — custom checked exceptions surfaced to the user with meaningful messages instead of generic runtime failures.

---

## ⚙️ Installation & Setup

### Prerequisites

- JDK 25
- Maven

### Clone the repository

```bash
git clone https://github.com/Rupsa667/Order-Management-System.git
cd Order-Management-System
```

### Build the project

```bash
mvn clean compile
```

### Run the application

**Option 1 — via Maven/command line:**

```bash
java -cp target/classes com.example.Main
```

**Option 2 — via IDE (IntelliJ IDEA, Eclipse, etc.):**

Open the project and run `Main.java` directly.

---

## 📖 Usage

On launch, you'll see a menu-driven console interface:

```
1. add items
2. display items
3. update items
4. remove items
5. search items
6. sort all items by 1.name 2.price
7. exit
Enter your choice:
```

### Example session

```
Enter your choice: 1
Enter item no: 100
Enter item name: pen
Enter price: 10
Item added successfully

Enter your choice: 2
Item(itemId=100, itemName=pen, price=10.0)

Enter your choice: 5
Enter item name to be searched: pen
item id is: 100 and price is: 10.0

Enter your choice: 6
Enter option
2
Item(itemId=101, itemName=eraser, price=8.0)
Item(itemId=100, itemName=pen, price=10.0)
Item(itemId=105, itemName=box, price=20.0)
Item(itemId=110, itemName=geometry, price=50.0)
```

---

## 🎯 Learning Outcomes

By studying this project, you'll understand:

- Interface-driven design in Java
- Custom checked exceptions and when to use them
- The Comparator/Strategy pattern for flexible sorting
- Working with `Set` collections and avoiding duplicate entries
- Using Lombok to reduce boilerplate in model classes

---

## 👩‍💻 Author

**Rupsa**

---

### ⭐ If you found this project helpful, consider starring the repository!
