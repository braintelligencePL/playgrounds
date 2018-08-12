trait OperatingOnTeamEndpoint implements CommunicatingWithEndpoint {

    ResultActions postNewTeam(String name) {
        mockMvc.perform(post("/teams").content())
    }

}