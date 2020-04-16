## Sainsbury’s Test Application 

### Task 

Task details specified [here](https://jsainsburyplc.github.io/serverside-test/).

### Project 

The project uses Java 1.8, Maven for managing project dependencies and Jsoup libraray for scraping webpages.


## Building and Running


### Running From Command Line

##Running the app

If the URI Parameter is provided then it is considered otherwsie the URL specified in the task is used

```bash
mvn spring-boot:run -Drun.arguments=(URI Optional)
```

## Running Tests

```bash
mvn clean tests
```

### Improvements

The way the search for elements are done in the HTML is rigid and maybe not very generic. So that search can be improved. Also search criteria and assumptions are made based on the URL which is given in the task 

More tests need to be written to cover edge case scenarios

### Error handling

There can be a many different errors that may occur when parsing HTML. Have tried to add exception messages but in case of errors have printed stack traces to help for debugging and trouble shooting


### Testing

Wrote unit tests for main logic in service classes
More tests need to be added to cover edge cases
