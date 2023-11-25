Automation Project: JSON to SQL Import
Objective
This project aims to automate the process of exporting data from a JSON file and importing it into an SQL table. The script is designed to handle exceptions, provide flexibility with the SQL connection string, and ensure the secure removal of the original JSON file after successful data insertion.

Getting Started
Prerequisites
Python (Version 3.8)
Required Python libraries: pyodbc
Installation
Clone the repository:

bash
Copy code
git clone git clone https://github.com/billy-cpp/Int-Projects.git
Install the required libraries:

bash
Copy code
pip install -r requirements.txt
Usage
Navigate to the project directory:

bash
Copy code
cd Automation_Python_SQL
Run the script:

bash
Copy code
python project.py
Follow the on-screen prompts to input the JSON file path, SQL connection string, and other relevant information.

Sit back and let the script handle the rest!

Configuration
Modify the config.json file to customize settings such as database name, table name, etc.
Exception Handling
The script is designed to handle common exceptions gracefully. In case of any issues, refer to the console output for error messages and follow the prompts for resolution.

Cleanup
After successful data insertion, the original JSON file is automatically deleted to maintain a clean and organized workspace.

Contributing
Feel free to contribute by submitting pull requests. Bug reports and feature requests are welcome via the Issues section.
