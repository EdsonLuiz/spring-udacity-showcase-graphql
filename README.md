## Schema

- Define data points offered by the API
- Contain the data types
- Contain relations between then
- Container operations available
- Queries, for retrieve data
- Mutations, for creating, updating and deleting data

The file extension for  GraphQL schema file is `.graphqls`

```graphql
# file.graphqls

type Location {
	id: ID!
	name: String!
	address: String!
}

type Query {
	findAllLocations: [Location]!
}

type Mutation {
	newLocation(name: String!, address: String!): Location!
	deleteLocation(id: ID!): Boolean
	updateLocationName(newName: String!, id: ID!): Location!
}
```

## Operations

- Queries.
- Mutations.
- Each query returns a specific object.
- Mutations update data

## Queries and mutations

- Create a Repository
- Create a Query Resolver that implements GraphQLQueryResolver and consume the Repository.
- Create all public methods that will be exposed by GraphQL API.