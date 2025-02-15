# QuizMaker

QuizMaker is a command-line application that allows users to create, manage, and take quizzes. It supports saving quizzes to a file using JSON, so quizzes persist even after restarting the program.

##  Features
- Create new quizzes with multiple questions and answers.
- View all available quizzes.
- Access existing quizzes to add or remove questions.
- Take a quiz and receive a score.
- Save quizzes persistently using JSON.


## Usage
### Main Menu Options
 **(A)**ccess Existing Quiz – Enter the name of an existing quiz to modify or take it.
 **(V)**iew Quizzes – Display all available quizzes.
 **(C)**reate New Quiz – Create a quiz and add questions.
 **(R)**emove Quiz – Delete a quiz from the system.
 **(Q)**uit – Exit the application.

## Installation
### Prerequisites

- Java (JDK 17 or later recommended)
- Gson library for JSON handling

### Steps

1. Clone this repository:

``` git clone https://github.com/your-username/QuizMaker.git ```

2. Navigate to the project directory:

``` cd QuizMaker ```

3. Compile the Java files: 

``` javac -cp .;gson.jar com/mateus/quizmaker/*.java ```

4. Run the application: 

``` java -cp .;gson.jar com.mateus.quizmaker.Main ```


## Contributing

- Feel free to fork this repository and submit pull requests!