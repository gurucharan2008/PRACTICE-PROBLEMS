# Week 2 Practice Problems (Day 2 Live-Coding Session)

## 1. Vowel & Consonant Counter
Count vowels (a,e,i,o,u case-insensitive) and consonants; ignore spaces.

**Method:** `void countVowelsAndConsonants(String text)`

**Sample:** `"Java Programming"` → Vowels: 5 | Consonants: 10

---

## 2. CSV Student Record Parser
Split `"Name,RollNumber,Department"`. Exactly 3 fields or "Invalid Record".

**Method:** `void parseStudentRecord(String csvLine)`

**Sample:** `"Ananya Verma,RA2211003010123,CSE"` → formatted record

---

## 3. File Extension Validator
Accept only pdf / docx / zip (case-insensitive).

**Method:** `String validateFileExtension(String filename)`

**Sample:** `"Assignment1.PDF"` → Accepted | `"notes.txt"` → Rejected

---

## 4. Masked Phone Number Formatter
Exactly 10 digits → `XXXXXX-last4`. Else "Invalid phone number".

**Method:** `String maskPhoneNumber(String phone)`

**Sample:** `"9876543210"` → XXXXXX-3210

---

## 5. Bank Transaction Reference Generator & Validator
Normalize (trim + uppercase bank code). Valid = 14 chars: 3 letters + 11 digits.
Format: `[BANK] DATE: dd/MM/yy | SEQ: 12345`

**Methods:** `normalizeReference` + `validateAndFormat`

**Sample:** `"  hdf03022600042  "` → `[HDF] DATE: 03/02/26 | SEQ: 00042`
