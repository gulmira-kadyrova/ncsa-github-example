Feature: Search Repositories

  Scenario Outline: Simple search functionality

    Given github rest api endpoint "https://api.github.com/search/repositories"

    When I search for a repository with details
      | q                 | <RepositoryKeyword> |
      | sort              | <Sort>              |
      | order             | <Order>             |

    Then the following result should be returned
      | expectedStatusCode | <StatusCode>      |
      | expectedKeyword    | <ExpectedKeyword> |

    Examples:
    | RepositoryKeyword   | Sort        | Order  | StatusCode  | ExpectedKeyword   |
    | ncsa-github-example | 2020-06-08  | desc   | 200         | gulmira-kadyrova  |
    | ncsa.github.io      | 2020-06-08  | desc   | 200         | ncsa.github.io    |
    | invalidrepositoryexample |        |        | 200         | "total_count": 0  |
