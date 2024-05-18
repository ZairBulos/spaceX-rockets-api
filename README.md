<div align="center">

![SpaceX Rockets](https://images.unsplash.com/photo-1517976547714-720226b864c1?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D)

# SpaceX Rockets API

API GraphQL para consultar información sobre los cohetes de SpaceX, empresa estadounidense de fabricación aeroespacial y de servicios de transporte espacial.

[![Interface](https://img.shields.io/badge/Interface%20-%20GraphQL%20-%20green?color=purple)](https://es.wikipedia.org/wiki/GraphQL)
[![Release](https://img.shields.io/badge/Release%20-%20v1.0.0%20-%20blue?color=blue)](https://github.com/ZairBulos/spaceX-rockets-api/releases)
[![License](https://img.shields.io/badge/License%20-%20MIT%20-%20yellow?color=green)](https://opensource.org/license/mit)

</div>

## Índice

- [Introducción](#introducción)
- [Recursos Disponibles](#recursos-disponibles)
- [Créditos](#créditos)
- [Licencia](#licencia)

## Introducción

Accede a la interfaz de GraphQL `https://spacex-rockets-api.onrender.com/graphiql?path=/graphql`.

## Recursos Disponibles

### Obtener todos los cohetes

````graphql
query FindAll {
  getAllRockets {
    id
    name
    description
    active
    stages
    boosters
    costPerLaunch
    successRatePct
    firstFlight
    country
    height {
      meters
      feet
    }
    diameter {
      meters
      feet
    }
    mass {
      kg
      lb
    }
  }
}
````

### Obtener cohete por id

````graphql
query FindOne($id: ID!) {
  getRocketById(id: $id) {
    id
    name
    description
    active
    stages
    boosters
    costPerLaunch
    successRatePct
    firstFlight
    country
    height {
      meters
      feet
    }
    diameter {
      meters
      feet
    }
    mass {
      kg
      lb
    }
  }
}
````

## Créditos

El modelo y los datos de este proyecto se han obtenido de [r-spacex/SpaceX-API](https://github.com/r-spacex/SpaceX-API).

## Licencia

Este proyecto está licenciado bajo la [Licencia MIT](/LICENSE.md).
