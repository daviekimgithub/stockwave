# stockwave# Stock Market Report App

Welcome to the Stock Market Report App, a mobile application that provides a comprehensive stock market analysis for 10 random companies. This app is designed for both Android and iOS platforms and offers a range of features to help users stay informed about the stock market.

## Features

### 1. Stock Market Data
- View detailed stock market data for 10 randomly selected companies.
- Get insights into the latest stock prices, trading volumes, and more.

### 2. Date Range Analysis
- Select a specific date range to analyze stock performance.
- Use date pickers to choose a start and end date for the analysis.

### 3. Company Search
- Easily find companies using the autocomplete search box.
- As you type, the list of companies dynamically filters based on your search query.

### 4. Offline Notification
- Stay informed even when the device is offline.
- Receive notifications about the current offline status and suggestions for actions.

## Architecture

The Stock Market Report App follows a robust architectural pattern to ensure maintainability and scalability.

### MVVM (Model-View-ViewModel)
- The project utilizes the MVVM architecture, separating concerns into distinct layers for clarity and modularity.

### Jetpack Compose with Kotlin
- Jetpack Compose is the framework of choice for building the user interface. It leverages the power of Kotlin to create dynamic and responsive UI components.

### State and Actions
- To manage the dynamic behavior of the UI, the app uses state management along with actions to trigger updates and changes in the user interface.

### Layers
- The project is structured into three essential layers:
  - Data Layer: Responsible for data handling, retrieval, and storage.
  - Domain Layer: Contains the core business logic and use cases of the application.
  - Presentation Layer: Handles UI components, interactions, and state management.

### Dependency Injection
- Koin is employed for dependency injection. It simplifies object creation and provides dependencies where needed, promoting clean and maintainable code.

### Networking
- Ktor client is the networking library used for making network requests to the marketstack.com API.

## Offline Handling

The Stock Market Report App actively monitors network connectivity to ensure a seamless user experience. If the device goes offline, the app will display a notification to inform the user. The notification includes suggestions on actions the user can take while offline.

## API Integration

This app relies on the marketstack.com API to fetch stock market data. To use this API, you must sign up on marketstack.com and obtain an API key. Place your API key in the appropriate configuration file.

For more detailed information and to access the source code, please visit the [GitHub Repository](https://github.com/daviekimgithub/stockwave).

Feel free to explore, contribute, and use the Stock Market Report App to stay informed about the stock market. Happy trading!
