#verbose=true

bean.id.1=invoker
invoker.class=command.Invoker
invoker.property.1=commande
invoker.property.1.param.1=cmdProjecteur

bean.id.2=lampeDeLAmphi
lampeDeLAmphi.class=command.Light

bean.id.3=cmd
cmd.class=command.CommandLight
cmd.property.1=lampe
cmd.property.1.param.1=lampeDeLAmphi

bean.id.4=projecteurDeLAmphi
projecteurDeLAmphi.class=command.Projecteur

bean.id.5=cmdProjecteur
cmdProjecteur.class=command.CommandeProjecteur
cmdProjecteur.property.1=projecteur
cmdProjecteur.property.1.param.1=projecteurDeLAmphi

