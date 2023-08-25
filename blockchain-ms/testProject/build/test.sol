contract GestionDesTransactions {




    // Structure pour représenter une transaction
    struct Transaction {
        bool state; // etat du transaction
        uint256 amount; // Montant de la transaction
        uint256 date; // Timestamp de la transaction
        TransactionType transactionType; // Type de la transaction (enum)
    }


    // Enum pour représenter le type de transaction
    enum TransactionType {
        Retrait,
        Charge
    }

    // Structure pour représenter un département
    struct Departement {
        uint256 seuil; // Montant seuil du département
        address[] membres; // Liste des adresses des membres du département
        address[] retraitAutorises; // Liste des adresses autorisées à effectuer des retraits
        address[] rechargeAutorises; // Liste des adresses autorisées à effectuer des recharges
        Transaction[] transactions; // Liste des transactions du département
    }

    // Mapping pour lier les adresses aux départements
    mapping(address => Departement) public departements;



    // Fonction pour créer un département
    function creerDepartement(
        address[] memory membres,
        address[] memory retraitAutorises,
        address[] memory rechargeAutorises,
        uint256 seuil
    ) external {
        departements[msg.sender].membres = membres;
        departements[msg.sender].retraitAutorises = retraitAutorises;
        departements[msg.sender].rechargeAutorises = rechargeAutorises;
        departements[msg.sender].seuil = seuil;
    }

    // Fonction pour effectuer une transaction
    function effectuerTransaction(
        address departementAddress,
        bool isWithdrawal,
        uint256 amount,
        TransactionType transactionType
    ) external {
        require(
            isMembreOfDepartement(departementAddress, msg.sender),
            "Vous n'êtes pas membre de ce département."
        );

        Departement storage departement = departements[departementAddress];

        if (isWithdrawal) {
            require(
                isAutorise(departement.retraitAutorises, msg.sender),
                "Vous n'êtes pas autorisé à effectuer des retraits dans ce département."
            );
        } else {
            require(
                isAutorise(departement.rechargeAutorises, msg.sender),
                "Vous n'êtes pas autorisé à effectuer des recharges dans ce département."
            );
        }

        require(
            departement.seuil >= amount,
            "Le montant de la transaction dépasse le seuil du département."
        );

        departement.transactions.push(
            Transaction({
                isWithdrawal: isWithdrawal,
                amount: amount,
                date: block.timestamp,
                transactionType: transactionType
            })
        );

        departement.seuil -= amount;
    }

    // Fonction utilitaire pour vérifier si une adresse est membre d'un département
    function isMembreOfDepartement(address departementAddress, address membre)
        internal
        view
        returns (bool)
    {
        for (uint256 i = 0; i < departements[departementAddress].membres.length; i++) {
            if (departements[departementAddress].membres[i] == membre) {
                return true;
            }
        }
        return false;
    }

    // Fonction utilitaire pour vérifier si une adresse est autorisée à effectuer une action
    function isAutorise(address[] memory listeAutorisee, address personne)
        internal
        view
        returns (bool)
    {
        for (uint256 i = 0; i < listeAutorisee.length; i++) {
            if (listeAutorisee[i] == personne) {
                return true;
            }
        }
        return false;
    }
}
