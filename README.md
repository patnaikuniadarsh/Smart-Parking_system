# 🅿️ Smart Parking System Using BFS Graph Traversal

## 🎯 Problem Statement
Traditional parking systems are manual, unorganized, and inefficient. Drivers waste time searching for free slots, causing traffic congestion and poor space utilization.

## 💡 Solution
This system provides:
- Automated parking slot allocation using **BFS algorithm**
- Nearest free slot detection from entrance
- Waiting queue management when parking is full
- User-friendly **Java Swing GUI**

## ✨ Features
- Park a car (automatically finds nearest free slot using BFS)
- Remove a parked car
- Display parking status (free/occupied slots)
- Waiting queue for when parking is full
- Graph-based parking lot representation
- BFS algorithm for nearest slot search

## 🛠️ Technologies Used
- **Language:** Java
- **GUI Framework:** Java Swing
- **Data Structures:** Graph, HashMap, Queue
- **Algorithm:** Breadth First Search (BFS)

### ## BFS Algorithm for Nearest Parking Slot

### Graph Representation
- Each parking slot = **Node (Vertex)**
- Path between slots = **Edge**
- Parking lot = **Graph**


### BFS Search Process

| Step | Slots Checked | Explanation |
|------|---------------|-------------|
| 1 | Slot 4 | Entrance point (starting node) |
| 2 | Slot 3, 5 | Neighbors of entrance |
| 3 | Slot 2, 6 | Next level outward |
| 4 | Slot 1, 7 | Continue expanding |
| 5 | Slot 0, 8 | Further outward |
| 6 | Slot 9 | Last slot |

## Team Members

| Roll Number | Name |
|-------------|------|
| A24126510122 | BONDA GEETESH |
| A24126510132 | GUJJALA CHANDU |
| A24126510142 | KOTANA JOSHNAVI |
| A24126510152 | PATNAIKUNI ADARSH |
| A24126510154 | PENTAKOTA DESHIK |
| A24126510168 | TEKKAMU JOSHITHA |

Guide
Mrs. Botcha Vineela Rani (M.Tech, Ph.D)

Institution
ANIL NEERUKONDA INSTITUTE OF TECHNOLOGY & SCIENCES (A+)
