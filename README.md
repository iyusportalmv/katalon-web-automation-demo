# Web UI Test Automation — Registration Form (Katalon Studio)

Automated end-to-end functional and regression test suite built with **Katalon Studio** to validate the [Frontend Registration Form](https://iyusportalmv.github.io/iyus-frontend-form-js/).

## Key Automation Highlights
* **Dynamic Math CAPTCHA Solver (Groovy + Regex):** Automatically extracts randomized arithmetic questions (`+`, `-`, `×`, `/`) from the DOM, computes the exact result at runtime, and populates the answer field without hardcoded test data.
* **Positive & Negative Test Coverage:** Validates both successful form submission and client-side alert handling when an incorrect CAPTCHA answer is submitted.
* **Page-Based Object Repository:** Modular locator organization (`Page_Form Pendaftaran` & `Page_Halaman Konfirmasi`) using resilient XPath and attribute selectors.
* **Custom Browser Capabilities:** Configured Chrome `Desired Capabilities` (`--force-dark-mode` & `--enable-features=WebContentsForceDark`) for accessible dark-mode test execution.

## Tech Stack
* **Automation Tool:** Katalon Studio v11.7.0
* **Scripting Language:** Groovy / Java
* **Browser & Driver:** Google Chrome (WebDriver)
* **Target Application:** [iyus-frontend-form-js](https://iyusportalmv.github.io/iyus-frontend-form-js/)

## Test Scenarios Covered

| ID | Test Case / Suite Name | Type | Description | Status |
| :--- | :--- | :--- | :--- | :---: |
| **TC01** | `TC01_Positive_Registration` | Positive | Verifies successful form submission with valid user inputs and dynamically calculated Math CAPTCHA, asserting redirection to the greeting confirmation page. | PASSED |
| **TC02** | `TC02_Negative_Wrong_Captcha` | Negative | Verifies that submitting an intentionally wrong CAPTCHA answer blocks submission and triggers the expected browser alert (`"Penghitungan salah, silakan coba lagi."`). | PASSED |
| **TS01** | `TS01_Registration_Regression` | Test Suite | Executes `TC01` and `TC02` sequentially as a consolidated regression suite. | PASSED (2/2) |

## Project Structure
```text
katalon-web-automation-demo/
├── Object Repository/
│   ├── Page_Form Pendaftaran/
│   │   ├── button_Kirim
│   │   ├── input_Masukkan email Anda
│   │   ├── input_Masukkan jawaban
│   │   ├── input_Masukkan nama Anda
│   │   ├── input_Masukkan nomor handphone Anda
│   │   └── label_Captcha
│   └── Page_Halaman Konfirmasi/
│       └── h2_greeting
├── Test Cases/
│   ├── TC01_Positive_Registration
│   └── TC02_Negative_Wrong_Captcha
├── Test Suites/
│   └── TS01_Registration_Regression
├── screenshots/
│   └── test-suite-passed.png
└── README.md
