# Week 1 Practice Problems (Day 1 Live-Coding Session)

## 1. Rock-Paper-Scissors Game

Play N rounds (default 5). Computer moves randomly. Print round table + Wins / Losses / Draws / Win %.

**Method:** `String playRound(String playerMove, String computerMove)`

---

## 2. Palindrome Checker (3 Approaches)

Verify a string is a palindrome using:
1. Iterative (two pointers)
2. Recursive
3. Array reversal

All three must agree.

**Methods:** `isPalindromeIterative` / `isPalindromeRecursive` / `isPalindromeArrayReversal`

**Sample:** `"madam"` → all Palindrome | `"hello"` → all Not Palindrome

---

## 3. BMI Calculator for a Team

BMI = weight / (height²). Classify: Underweight / Normal / Overweight / Obese. Print table.

**Methods:** `getBmiStatus(double bmi)` + `printWellnessReport(double[] heights, double[] weights)`

---

## 4. First Non-Repeating Character

Find the first character that appears exactly once. Print it or "No Non-Repeating Character Found".

**Method:** `char findFirstNonRepeatingChar(String text)`

**Sample:** `"swiss"` → 'w' | `"aabbcc"` → not found

---

## 5. Reverse Customer Name

Reverse a name without modifying the original string. Print both.

**Method:** `String reverseCustomerName(String customerName)`

**Sample:** `"Sunil"` → Original: Sunil | Reversed: linuS
