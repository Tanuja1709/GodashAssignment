# GodashAssignment

# 🚀 Promotion Engine


📌 **Problem Statement**

Implement a **Promotion Engine** to calculate the total checkout value of a shopping cart containing products `A`, `B`, `C`, `D` with the following promotions:

- **Bulk Promotion**: Fixed price for buying `n` units of a SKU (e.g., 3 A's for 130 instead of 150).
- **Combo Promotion**: Fixed price for buying a combination of SKUs together (e.g., C + D for 30 instead of 35).

The system must:
- Apply multiple promotions in a single transaction.
- Return the correct total checkout amount.
- Be easily extensible to add or change promotions in future.

---

## ✅ Expected Output

| Scenario | Description                    | Expected Total |
|----------|--------------------------------|----------------|
| **A**    | 1 * A + 1 * B + 1 * C          | **100**        |
| **B**    | 5 * A + 5 * B + 1 * C          | **370**        |
| **C**    | 3 * A + 5 * B + 1 * C + 1 * D  | **280**        |

---

## 🛠️ Tech Stack

- **Java 17**
- **Spring Boot 3.5.3**
- **JUnit 5** — for Unit & Integration tests
- **Maven** — for build and dependency management
- **Postman** — to test REST API easily

---

## ✅ Solution Design

- Built using **Spring Boot** for a RESTful API structure.
- **OOP Principles**: Promotions are modeled using an interface and concrete implementations for `BulkPromotion` and `ComboPromotion`.
- **Loose Coupling**: Thanks to interfaces, adding new promotions in the future needs no change in existing code.
- Clean **Separation of Concerns**: Models (`SKU`, `CartItem`, `Cart`), Promotions, Engine, and REST layer are all separated.
- Fully tested using a **TDD** approach to ensure high confidence in correctness.

---

## ✅ TDD Process

1️⃣ Created basic models:
- `SKU` — represents a product.
- `CartItem` — product + quantity.
- `Cart` — holds multiple `CartItem` objects.

2️⃣ Defined `Promotion` interface — contract for all promotions.

3️⃣ Wrote **unit tests** for:
- `PromotionEngine` logic

4️⃣ Implemented promotion logic to pass the tests.

5️⃣ Created `PromotionEngineImpl` — applies promotions + calculates total.

6️⃣ Added **REST Controller**:
- Receives a list of cart items via JSON.
- Calls `PromotionEngine` to calculate total.
- Returns the total as a response.

7️⃣ Tested end-to-end using **JUnit** + **Postman**.

---

## ✅ How to Use the API

### 🟢 Endpoint

**Endpoint**: `POST http://localhost:8080/api/cart/calculate`

**Request Body**:
```json
[
  { "sku": "A", "quantity": 3 },
  { "sku": "B", "quantity": 2 },
  { "sku": "C", "quantity": 1 },
  { "sku": "D", "quantity": 1 }
]
```

## ▶️ How To Run This Project

### 1️⃣ Clone the repository

```bash
git clone https://github.com/<your-username>/<your-repo>.git
cd <your-repo>
```

### 2️⃣ Build the project
```bash
mvn clean install
```

### 3️⃣ Run the tests
```bash
mvn test
```

### 4️⃣ Start the application
```bash
mvn spring-boot:run
```

### 5️⃣ Test the API with Postman
Method: POST

URL: http://localhost:8080/api/cart/calculate

Header: Content-Type: application/json

Body: JSON array of SKUs & quantities, for example:
```json
[
  { "sku": "A", "quantity": 3 },
  { "sku": "B", "quantity": 2 },
  { "sku": "C", "quantity": 1 },
  { "sku": "D", "quantity": 1 }
]
```
Click Send — you will see the calculated total in the response.