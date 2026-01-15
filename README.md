# TBC -  Project (Test Automation)

**Project:** TBC Bank UI Automation Framework  
**Target Website:** [https://tbcbank.ge/ka](https://tbcbank.ge/ka)  

## 1.  Business Value

picked 5 important scenarios because doing them by hand takes too much time and mistakes can happen easily.

### Scenario 1: Location & ATM Filters
* **Why it matters:** If customers cannot filter "24/7" or "Cash In" ATMs, they might get angry and call the bank.
* **Why automate:** Checking hundreds of map points manually is hard. Automation checks this in seconds.

### Scenario 2: Search Functionality
* **Why it matters:** When people are lost on the site, they use Search
* **Why automate:** I need to make sure that if I search for a street name, the results actually show that street.

### Scenario 3: Loan Calculator
* **Why it matters:** Money calculations must be perfect. If the bank shows wrong monthly payments, it is a big problem.
* **Why automate:** Calculating interest rates by hand is slow. My test inputs numbers and checks the math instantly.

### Scenario 4: Offers & Sharing
* **Why it matters:** Offers help the bank sell products. The "Share" button needs to work so people can send offers to friends.
* **Why automate:** To make sure the marketing buttons are actually clickable and opening the right windows.

### Scenario 5: Tech School Registration
* **Why it matters:** TBC does a lot of education projects. If the registration link is broken, students cannot sign up.
* **Why automate:** The courses change a lot (dynamic content). My test checks that *whatever* course is there, the registration button works.

---

## 2. How I Found Elements (Selector Strategy)

I tried to pick selectors that wont break easily.

1.  **Text-Based (`//span[text()='...']`)**:
    * **Why:** For menu items like "Consumer Loan" (სამომხმარებლო), the text is the best way to find it.
    * **Priority:** High for menus.

2.  **CSS Classes (`.tbcx-pw-atm-branches-section__list-item-title`)**:
    * **Why:** company uses specific class names for components. These are safe to use.
    * **Priority:** High for lists and data.

3.  **Attributes (`input[type='number']`)**:
    * **Why:** Good for the Calculator inputs because the style might change, but the input type usually stays the same.

**What I avoided:** I tried not to use long XPaths like `/div/div[2]/div[4]` because if the bank adds one banner, my test would fail.

---

## 3. Fixing Flaky Tests

**Problem:**  `Search for Branch` test was sometimes failing.
* **Why:** When I typed a street name (like "ჭავჭავაძის"), the website took a few seconds to load the list of branches. test tried to check the list immediately while it was still empty, so it failed.
* **My Fix:**
    1.  I used `shouldHave(sizeGreaterThan(0))` to only look at elements that exist. 
   

Result: Now the test patiently waits for the data to load before checking it.
---

## 4. Mobile vs Desktop (responsive Testing)

**The Challenge:**
The TBC site looks different on a phone (iPhone X size).
* **Desktop:** You can see the menu links right away.
* **Mobile:** The menu is hidden behind a **Hamburger Button**. You have to click it first, then click "Loans" to see the links.

**My Solution:**
I wrote simple code to check in `HomePageSteps.java`:

```java
public HomePageSteps openConsumerLoanPage() {
    // If the mobile dropdown is visible, I click it first to open the menu
    if (homePage.mobileLoansDropdown.is(visible)) {
        homePage.mobileLoansDropdown.click();
    }
    // Then I click the link. This works for both Desktop and Mobile.
    homePage.consumerLoanLink.scrollTo().shouldBe(visible).click();
    return this;
}