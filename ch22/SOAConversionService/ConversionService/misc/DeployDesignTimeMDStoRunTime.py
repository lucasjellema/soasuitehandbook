# Copyright 2012, 2014 Oracle Corporation.
# All Rights Reserved.
#
#
# These are the arguments that you need to supply when running this script
# archive = filename of the JAR file with the document to import into MDS
# targetServer = name of the managed server on which the SOA Infra is running
# AdminServerUrl = the url for the Admin Server on the target domain
# user = username to connect to the admin server
# password = password to connect to the admin server

# method definitions
#

def main():

  print ' This script will import documents in to runtime MDS database'

  try:
    archive = sys.argv[1]
    targetServer = sys.argv[2]
    pAdminServerUrl= sys.argv[3]
    pUser= sys.argv[4]
    pPassword = sys.argv[5]
    
    print('--> about to connect to weblogic')
    connect(pUser, pPassword, pAdminServerUrl)

    print('--> about to import documents into a destination MDS repository ' )
    edit()
    startEdit()

    importMetadata(application='soa-infra', server=targetServer,fromLocation=archive, docs='/apps/**', remote='true')

    save()
    print('--> activating changes')
    activate()
    print('--> done')


  except:
    print('--> something went wrong, bailing out')
    stopEdit('y')
    raise SystemExit

  #
  # disconnect from the admin server
  #

  print('--> disconnecting from admin server now')
  disconnect()

#
#  this is the main entry point

main()