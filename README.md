# regressionTest for Create/Buy the Event/Voucher

A Selenium + TestNG regression test suite (Java 17, Maven) for customer and portal flows.

## Quick start (customer flows)
- Build:
```bash
mvn -DskipTests=true clean install
```
- Login (customer):
```bash
mvn -Dsurefire.suiteXmlFiles=testSuite/login.xml -Denv=staging -Dbrowser=chrome -Dui.enabled=true test
```
- Buy Events (full flow):
```bash
mvn -Dsurefire.suiteXmlFiles=testSuite/buyEvent.xml -Denv=staging -Dbrowser=chrome -Dui.enabled=true -Dwait.timeout.customer=20 test
```
- Buy Vouchers (full flow):
```bash
mvn -Dsurefire.suiteXmlFiles=testSuite/buyVouchers.xml -Denv=staging -Dbrowser=chrome -Dui.enabled=true -Dwait.timeout.customer=20 test
```

## Prerequisites
- Java 17+ (JDK)
- Maven 3.8+
- A desktop browser (Chrome, Firefox, or Safari)

Drivers are automatically managed by WebDriverManager; local binaries in `browserDrivers/` are not required.

## Configuration
- Environment and URLs are defined in `src/config_env/config.properties`.
  - Supported env values: `staging`.
- Customer test data lives in `src/datafile/customer/` (e.g., `login-phone.json`).

You can override the env from the CLI; the framework reads `-Denv` and also accepts TestNG `<parameter name="env" .../>` from the suite XMLs.

## Running tests
Use Maven Surefire with TestNG suite XMLs.

- Run a specific suite file:
```bash
mvn -Dsurefire.suiteXmlFiles=PATH/TO/YOUR_SUITE.xml test
```

- Examples (customer):
```bash
# Login only
mvn -Dsurefire.suiteXmlFiles=testSuite/login.xml -Denv=staging -Dbrowser=chrome -Dui.enabled=true test

# Full buy events flow
mvn -Dsurefire.suiteXmlFiles=testSuite/buyEvent.xml -Denv=staging -Dbrowser=chrome -Dui.enabled=true -Dwait.timeout.customer=20 test

# Full buy vouchers flow
mvn -Dsurefire.suiteXmlFiles=testSuite/buyVouchers.xml -Denv=staging -Dbrowser=chrome -Dui.enabled=true -Dwait.timeout.customer=20 test
```

## Useful system properties
- `-Denv=staging` Choose environment (defaults to `staging`)
- `-Dbrowser=chrome|firefox|safari` Choose browser (defaults to `chrome`)
- `-Dui.enabled=true|false` Run with visible browser (`true`) or headless (`false`, defaults to `true` in code)
- `-Dwait.timeout.customer=SECONDS` Override default explicit wait for customer flows (default `15`)
- `-Dwait.timeout.portal=SECONDS` Override default explicit wait for portal flows (default `20`)

Examples:
```bash
# Headless Firefox on Staging
mvn -Dsurefire.suiteXmlFiles=testSuite/buyEvent.xml -Denv=staging -Dbrowser=firefox -Dui.enabled=false test

# Increase wait time if your machine/network is slow
mvn -Dsurefire.suiteXmlFiles=testSuite/buyEvent.xml -Dwait.timeout.customer=25 test
```

## Reports
- Test output and reports are written to `target/surefire-reports`.

## Troubleshooting
- NoSuchElement/Timeout errors: try `-Dui.enabled=true` and/or increase `-Dwait.timeout.customer`.
- Chrome DevTools (CDP) warnings: these are generally harmless. If needed, pin a matching `selenium-devtools-vXXX` artifact to your Chrome version per Selenium guidance.
- Ensure your network can reach the configured URLs in `config.properties`.
