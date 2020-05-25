const graphql = require('graphql')
const _ = require('lodash')
const delay = require('delay');


// dummi data
var usersData = [
    {id: '1', age: 30, name: "Carmelo1", profession: "dev1"},
    {id: '2', age: 31, name: "Carmelo2", profession: "dev2"},
    {id: '3', age: 32, name: "Carmelo3", profession: "dev3"},
    {id: '4', age: 33, name: "Carmelo4", profession: "dev4"},
    {id: '5', age: 34, name: "Carmelo5", profession: "dev5"},
    {id: '6', age: 35, name: "Carmelo6", profession: "dev6"}
]

var hobbiesData = [
    {id: '1', title: 'Programming', description: 'description Programming', userId: '4'},
    {id: '2', title: 'Rowing', description: 'description Rowing', userId: '2'},
    {id: '3', title: 'Swimming', description: 'description Swimming', userId: '5'},
    {id: '4', title: 'Fencing', description: 'description Fencing', userId: '3'},
    {id: '5', title: 'Hiking', description: 'description Hiking', userId: '1'}
]

var postsData = [
    {id: '1', comment: 'Post1', userId: '1'},
    {id: '2', comment: 'Post2', userId: '5'},
    {id: '3', comment: 'Post3', userId: '4'},
    {id: '4', comment: 'Post4', userId: '2'},
    {id: '5', comment: 'Post5', userId: '1'},
    {id: '6', comment: 'Post6', userId: '3'},
    {id: '7', comment: 'Post7', userId: '1'}
]
    

const{
    GraphQLObjectType,
    GraphQLID,
    GraphQLString,
    GraphQLInt,
    GraphQLSchema,
    GraphQLList
} = graphql

//Create type
const UserType = new GraphQLObjectType({
    name : 'User',
    description: 'Documentation for user...',
    fields: () => ({
        id: {type: GraphQLString},
        name: {type: GraphQLString},
        age: {type: GraphQLInt},
        profession: {type: GraphQLString},
        posts: {
            type: new GraphQLList(PostType),
            resolve(parent, args){
                return _.filter(postsData, { userId: parent.id })
            }
        },
        hobbies: {
            type: new GraphQLList(HobbyTepe),
            resolve(parent, args){
                return _.filter(hobbiesData, { userId: parent.id })
            }
        }
    })
})

const HobbyTepe = new GraphQLObjectType({
    name: 'Hobby',
    description: 'Hobby description',
    fields: () => ({
        id: {type: GraphQLID},
        title: {type: GraphQLString},
        description: {type: GraphQLString},
        user: {
            type: UserType,
            resolve(parent, args){
                return _.find(usersData, { id: parent.userId })
            }
        }
    })
})

const PostType = new GraphQLObjectType({
    name: 'Post',
    description: 'Post description',
    fields: () => ({
        id: {type: GraphQLID},
        comment: {type: GraphQLString},
        user: {
            type: UserType,
            resolve(parent, args){
                return _.find(usersData, { id: parent.userId })
            }
        }
    })
})

// RootQuery

const RootQuery = new GraphQLObjectType({
    name: 'RootQueryType',
    description: 'Description',
    fields: {
        user:{
            type: UserType,
            args: { id: {type: GraphQLString}},
            resolve(parent, args){
                sleep(5000)
                return _.find(usersData, {id: args.id})
                // we resolve with data
                // get and return data from a datasource
            }
        
        },
        hobby: {
            type: HobbyTepe,
            args: { id: {type: GraphQLID}},
            resolve(parent, args){
                return _.find(hobbiesData, {id: args.id})
            }
        },
        post: {
            type: PostType,
            args: { id: {type: GraphQLID}},
            resolve(parent, args){
                return _.find(postsData, {id: args.id})
            }
        }
    }
})

module.exports = new GraphQLSchema({
    query: RootQuery
})

function sleep(milliseconds) {
    const date = Date.now();
    let currentDate = null;
    do {
      currentDate = Date.now();
    } while (currentDate - date < milliseconds);
  }



