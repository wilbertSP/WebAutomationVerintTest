Feature: Search on Verint Website

  Background:
    Given User is on Verint website

  Scenario: User navigates to the search menu
    Given User is on the search page
    When User enter the term "customer solution"
    Then User sees an article that mentions the term "customer solutions"