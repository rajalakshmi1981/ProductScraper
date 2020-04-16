## Sainsbury’s Test Application 

### Task 

Task details specified [here](https://jsainsburyplc.github.io/serverside-test/).

### Project 

The project uses Java 1.8, Maven for managing project dependencies and Jsoup libraray for scraping webpages.


## Building and Running


### Packaging

To build an executable `.jar`:

```bash
mvn clean package
```

### Running From Command Line

If the URI Parameter is provided then it is considered otherwsie the URL specified in the task is used

To run the `.jar`:

```bash
java -jar target/sainsburys-scraper-0.0.1-SNAPSHOT.jar <URI Parameter(Optional)>
```

### Improvements

The way the search for elements are done in the HTML is rigid and maybe not very generic. So that search can be improved. Also search criteria and assumptions are made based on the URL which is given in the task 

### Error handling

There can be a many different errors that may occur when parsing HTML. Have tried to add exception messages but in case of errors have printed stack traces to help for debugging and trouble shooting



