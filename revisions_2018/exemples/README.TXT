# exemple extrait du support, NFP121, injection de dépendances

#
verbose=true

bean.id.1=a
a.class=exemples.A
a.property.1=i
a.property.1.param.1=b
a.property.2=f
a.property.2.param.1=3.154
a.property.3=tab
a.property.3.param.1=3 54 4 6 7

bean.id.2=b
b.class=exemples.B

bean.id.3=b1
b1.class=exemples.B1

bean.id.4=table
table.class=exemples.Table
table.property.1=collection
table.property.1.param.1=liste

bean.id.5=liste
liste.class=java.util.HashSet

bean.id.6=gui
gui.class=config_editor.GUI

bean.id.7=fabrique
fabrique.class=exemples.Factory
fabrique.property.1=instance
#fabrique.property.1.param.1=java.util.TreeSet.class
fabrique.property.1.param.1=java.util.HashSet.class

