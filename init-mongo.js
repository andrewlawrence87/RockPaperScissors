db.createUser(
    {
        user : "RockMan",
        pwd : "FearThePaper",
        roles : [
            {
                role : "readWrite",
                db : "RockPaperScissorsDB"
            }
        ]
    }
)