# Alea Knowledge Test: PokemonAPI

Welcome to Alea Knowledge Test!
Below we indicate the instructions that must be followed to complete the knowledge test.

In Alea, we are gaming fanatics and we want to expose an API
with the following scenarios:
1. The 5 heaviest Pokémons.
2. The 5 highest Pokémons.
3. The 5 Pokémons with more base experience.
   
The source of the data is the PokéAPI (https://pokeapi.co/api/v2/). 

Must have:
   - Create a Java/SpringBoot application
   - Test coverage of at least 90%

Nice to have:
   - Integration test
   - Production ready

Use a readme file to explain to us all decisions that you made, and all improvements that you would like to do and you didn't have enough time to implement

---

# Decisions Made

### Using the official SDK for PokeApi
After checking the API's documentation I saw that they have an official SDK (or wrappers as they call them in the documentation) for JAVA, so I decided to use it.

### Structure
I wanted to go for a DDD-like approach (but simplified for this particular small application) since we are basing the application on a third party, 
I wanted to have an immutable source of truth for the services to work with, independently of whatever changes may introduce the PokeApi, or if we had to change the third party at all. 
This required several layers of mappers to translate from the PokeAPI to the domain, and from the domain to the database/API response.

While this introduces several different classes, even for a small application, it promotes the right responsibility for each class and facilitates code reading and testing.

### Solution approach
Since I do not think Pokémon are very likely to change very often and did not see a way to filter directly through the API,
I decided to do an initial pull at start-up to get all the Pokémon and store them in a database with only the important information
relative to this application. Then all the requests done to the application would work over the database.

# Improvements
### Pokémon Adapter
The Pokémon adapter runs at start-up with a `@PostConstruct` annotation. This means that the application will only work for the
Pokémon that existed in the PokeApi at start-up time. I would extract this logic to its own application, so that they are independent of each other.

Another thing to consider would be to improve the performance while mapping all the Pokémon and saving them the database.

To improve further this Adapter, I would run it on a scheduler/batch so that it periodically pulls the information from the PokeApi 
and updates the database. This way I could ensure that the information is up-to-date (new Pokémon, change in stats, etc...)

### Database
The database is a plain SQL table with the relevant information of a Pokémon with no indexes or performance improvements. 
I would probably study various possibilities to improve the query performance like indexes or materialized views, see what
gives the best results in performance and implement it as well.

### Caches
As I mentioned before the information should be pretty static, which means there is no point in going to the database directly
each time we receive a request. For this reason I would cache the results from each query for a certain amount of time to avoid 
hitting the database unnecessarily.

# Testing
I am basing the coverage on the `Run with Coverage` from IntelliJ. 
Based on this the `adapter`, `controller`, `service` and `mapper` packages are fully covered.

I did not have time to add Integration testing, but I would add `TestContainers` to populate a mocking DB and call to PokeApi,
add some Pokémon and develop the tests to see the endpoints are retrieving the data correctly.