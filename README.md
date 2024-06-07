# Currency converter
- A simple Currency exchange app using API - https://freecurrencyapi.com/docs/

![Screenshot_20240608_031135.png](..%2F..%2F..%2FDesktop%2FScreenshot_20240608_031135.png)

## Features

- App displays monthly requests left for the month
- User can select a base and target currency to convert a input amount
- Result quote is displayed and if user approves, the approved transaction is added under recent transactions

## Technologies and Libraries Used

- Android Jetpack Compose: Modern UI toolkit for building native Android UI.
- Kotlin Coroutines: For asynchronous and concurrent programming.
- Room: Android's SQLite database library for local data storage.
- ViewModel: Part of the Android Architecture Components, used to manage UI-related data in a lifecycle-aware manner.
- Retrofit: HTTP client library for making network requests.
- Gson: JSON serialization/deserialization library for parsing API responses.
- Dagger Hilt: Dependency injection framework for Android.
- Kotlin DSL: Gradle build scripts written in Kotlin.

## Architecture

- The app follows the principles of Clean Architecture, which promotes separation of concerns and modular development. The architecture consists of the following layers:

- Presentation: Contains the Jetpack Compose UI components, ViewModels, and UI-related logic.
- Domain: Contains the business logic and defines the use cases of the application.
- Usecase: Implements the concrete implementations of the data sources, such as network and local database.
- Data: Handles data operations, including fetching data from the network and accessing the local database using Room.
- Dependency Injection: Uses Dagger Hilt for dependency injection, enabling modular and testable code.


## Improvements for future

- Enhanced UI validation and UX 
- Error handling and appropriate error messages shown to user upon failure
- Storing data in better format. e.g. Storing conversion rates in float rather than in string
- Accessibility support can be added
- Modularisation of features
