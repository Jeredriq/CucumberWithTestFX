Feature: Do label texts exist?
  This feature controls if the label texts exist and can be found by testfx via cucumber


  Scenario: Can you find this label text
  Given That "Can you find this label" Exists
  Then Which is "great"
#  Scenario Outline:
#  Given Want to find <labelText>
#  Then Say <myReaction>
#
#  Examples:
#     | labelText | myReaction |
#     | "Item1" | "YAY!" |
#     | "Can you find this label text" | "Here it is" |
#     | "This text doesnt exist" | "nay, it doesnt exist" |