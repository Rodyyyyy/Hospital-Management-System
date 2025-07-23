# Patient Management System

A Java-based hospital management system for patient records, appointments, and billing with data structures for efficient operations.

## Features

- **Patient Management**:
  - Add new patients with complete medical profiles
  - Search and update patient information
  - Track visit history and medical records
- **Appointment System**:
  - Schedule, cancel, and reschedule appointments
  - Manage waiting lists
  - Track patient conditions
- **Billing System**:
  - Process payments
  - Generate revenue reports
- **Data Structures**:
  - Binary Search Tree for efficient patient search
  - Linked List for waiting list management
  - ArrayLists for visit records and revenue tracking

## Class Structure

| Class | Description |
|-------|-------------|
| `Patient` | Core patient data and medical information |
| `Appointment` | Handles scheduling and appointment status |
| `BinarySearchTree` | Efficient patient search by ID |
| `LinkedList` | Waiting list implementation |
| `PatientManagementSystem` | Main system operations and UI |
| `Node` | Supporting class for data structures |
| `Billing` | Payment processing and receipts |

## How to Use

1. **Patient Operations**:
   - Add new patients with complete details
   - Search patients by ID
   - Update contact information
   - Add visit records

2. **Appointment Management**:
   - Schedule new appointments
   - Cancel existing appointments
   - View waiting list
   - Track patient conditions

3. **Billing System**:
   - Process patient payments
   - Generate billing receipts
   - View revenue reports

## Technical Details

- **Data Structures**:
  - Binary Search Tree (O(log n) search)
  - Linked List (O(1) insert/delete)
  - ArrayLists for dynamic collections
- **Design Patterns**:
  - Separation of concerns
  - Modular component design
- **Input Validation**:
  - Type checking for numeric inputs
  - Existence checks for patients

## Requirements

- Java Runtime Environment (JRE) 8 or later

## Installation

1. Compile all Java files:
   ```bash
   javac *.java
