# AutoX

## HLD
![image alt](https://github.com/SathvikSDET/AutoX/blob/e34d5f4de39e28035d381db0370d7f5529d54aae/HLD.png)


# 🏆 AutoX - Test Automation Framework using TestNG, Selenium, Appium, and RestAssured

This repository contains a scalable **Test Automation Framework** built with **Java, TestNG, Selenium, Appium, and RestAssured** for **UI, API, and Mobile Testing**.

---

## 🔥 Features
- ✔ **TestNG-based Test Execution**
- ✔ **Page Object Model (POM) for Web & Mobile**
- ✔ **Support for UI, API, and Mobile Testing**
- ✔ **CI/CD Integration (Jenkins, GitHub Actions)**
- ✔ **Parallel & Cross-Browser Execution**
- ✔ **Logging & Reporting (Extent Reports)**
- ✔ **Configuration Management**

---

## 🚀 Tech Stack

| Category       | Tools/Frameworks |
|---------------|----------------|
| **Language**  | Java (17+) |
| **Test Framework** | TestNG |
| **Web UI Automation** | Selenium |
| **Mobile Automation** | Appium |
| **API Testing** | RestAssured |
| **Build Tool** | Maven / Gradle |
| **Reporting** | Extent Reports / Allure |
| **Version Control** | Git / GitHub |
| **CI/CD** | Jenkins, GitHub Actions |
| **AI** | deepSeek |


## ⚙️ Setup & Installation

### 1️⃣ Clone the repository
```sh
git clone https://github.com/your-repo/automation-framework.git
cd automation-framework
```

### 2️⃣ Configure Dependencies
- **For Maven Users:**
  ```sh
  mvn clean install
  ```
- **For Gradle Users:**
  ```sh
  gradle build
  ```

### 3️⃣ Configure Test Execution
- Update the **`config.properties`** file:
  ```
  browser=chrome
  baseUrl=https://your-app.com
  runMode=local
  ```
- Modify **TestNG Suite (`testng.xml`)** as needed.

### 4️⃣ Run Tests
- **Execute all tests:**  
  ```sh
  mvn test
  ```
- **Run specific test suite:**  
  ```sh
  mvn test -DsuiteXmlFile=testng.xml
  ```
- **Parallel Execution (Example)**  
  ```sh
  mvn test -Dthreads=2
  ```

---

## 🐛 Configuration Management
The `ConfigManager.java` handles test configurations, reading values from `config.properties`.

Usage Example:
```java
String browser = ConfigManager.getProperty("browser");
```

---

## 📊 Test Reports

### 1️⃣ Extent Reports
After test execution, reports are generated in:
```
test-output/ExtentReports/
```

### 2️⃣ Allure Reports
```sh
allure serve allure-results
```

---

## 🛠️ CI/CD Integration
This framework supports **Jenkins & GitHub Actions**.
- Add `Jenkinsfile` for automated pipeline execution.
- Use `.github/workflows/ci.yml` for GitHub Actions.

---

## Build Project JAR AutoX

1. mvn clean package -DskipTests
---

#Run tests using JAR:

1. java -cp "target/docker-resources/AutoX-docker-tests.jar:target/docker-resources/AutoX-docker.jar:target/docker-resources/libs/*" 
             -Dselenium.grid.enabled=false
             -Dbrowser="${BROWSER:-chrome}"
             -threadcount "${THREAD_COUNT:-1}"
   org.testng.TestNG testng.xml 
             
---

## 🤝 Contributing
1. **Fork** the repository.  
2. **Create a branch:** `git checkout -b feature-branch`  
3. **Commit changes:** `git commit -m "Added new feature"`  
4. **Push to the branch:** `git push origin feature-branch`  
5. **Create a Pull Request!**  




