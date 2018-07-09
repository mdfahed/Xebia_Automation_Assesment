$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("features/SearchFlights.feature");
formatter.feature({
  "line": 1,
  "name": "Search Flights",
  "description": "",
  "id": "search-flights",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Search Flights Test",
  "description": "",
  "id": "search-flights;search-flights-test",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 5,
  "name": "Bill has decided to check available flights",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "he looks at a return trip from \"DXB\" to \"LHR\" leaving one week from now",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "he should be shown the cheapest return ticket from DXB to LHR",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchFlightsStepDefinition.bill_has_decided_to_check_available_flights()"
});
formatter.result({
  "duration": 25351723855,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "DXB",
      "offset": 32
    },
    {
      "val": "LHR",
      "offset": 41
    }
  ],
  "location": "SearchFlightsStepDefinition.he_looks_at_a_return_trip_from_to_leaving_one_week_from_now(String,String)"
});
