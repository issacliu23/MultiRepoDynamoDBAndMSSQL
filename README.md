# Guide - Local Dynamo DB and MSSQL integrated with Spring Boot
## Install AWS CLI
1. Open browser, click the following link to install latest AWS CLI 
    https://awscli.amazonaws.com/AWSCLIV2.msi
2. Install AWS CLI using the downloaded msi in Step 1
3. Verify the installation by checking the version in CMD. The version should be displayed.
    ```sh
    aws --version
    ```
    Result:
    > aws-cli/2.3.2 Python/3.8.8 Windows/10 exe/AMD64 prompt/off
## Install Local DynamoDB 
1. Open browser, navigate to https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html
2. Under Asia Pacific (Singapore) Region, download DynamoDb jar in zip format.
3. Once file has been downloaded, unzipped and place it in any folder.
4. Launch Local DynamoDB, default port is 8000
    ```sh
    java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
    ```
5. Configure AWS CLI with mock access key 
    ```sh
    aws configure
    AWS Access Key ID []: fakeMyKeyId
    AWS Secret Access Key []: fakeSecretAccessKey
    Default region name [None]:
    Default output format [None]:
    ```
6. Test local connection to DynamoDB
    ```sh
    aws dynamo list-tables --endpoint-url http://localhost:8000
    ```
    Result:
    > {
    "TableNames": []
    }
