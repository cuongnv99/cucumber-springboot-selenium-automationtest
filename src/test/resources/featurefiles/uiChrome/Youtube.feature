@uiChrome
  Feature: YouTube Test chrome
    Scenario: Verify YouTube Channel name chrome
      When I go to page on chrome "https://www.youtube.com/channel/UCH0L0UYACGQTXLXaXp5k_yA"
      Then I verify YouTube channel name onchrome "Cường Nguyễn"