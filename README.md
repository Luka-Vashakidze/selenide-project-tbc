# TBC Bank UI Test Automation Framework

Automated test suite for [TBC Bank](https://tbcbank.ge) built with 
Selenide, Java, TestNG, and BackstopJS for visual regression.

## Coverage

| Scenario | Type | Notes |
|---|---|---|
| ATM/Branch Filter | UI | 24/7, Cash In filter validation |
| Site Search | UI | Branch/street search with async wait handling |
| Loan Calculator | UI | Input validation + math output verification |
| Offers & Share | UI | CTA button + modal behavior |
| Tech School Registration | UI | Dynamic content, registration flow |

## Tech Stack
- **Framework:** Selenide + TestNG
- **Language:** Java
- **Visual Regression:** BackstopJS
- **Build:** Maven

## Key Technical Decisions
- Avoided brittle XPath chains; prioritized text-based and 
  attribute selectors for maintainability
- Handled async branch list loading with `shouldHave(sizeGreaterThan(0))`
  to eliminate flakiness
- Responsive-aware: single test flow handles both desktop 
  and mobile hamburger menu via conditional element check

## How To Run
```bash
mvn test
```
Requires: Java 17+, Maven, Node.js (for BackstopJS)

## Visual Regression
BackstopJS baseline screenshots stored in `/backstop_data`.  
Run `backstop test` to compare against baseline.
