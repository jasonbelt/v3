#!/bin/bash
#
# Copyright (c) 2016, Robby, Kansas State University
# All rights reserved.
#
# Redistribution and use in source and binary forms, with or without
# modification, are permitted provided that the following conditions are met:
#
# 1. Redistributions of source code must retain the above copyright notice, this
#    list of conditions and the following disclaimer.
# 2. Redistributions in binary form must reproduce the above copyright notice,
#    this list of conditions and the following disclaimer in the documentation
#    and/or other materials provided with the distribution.
#
# THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
# ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
# WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
# DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR
# ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
# (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
# LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
# ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
# (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
# SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
#
set -e
SIREUM_HOME=$( cd "$( dirname "$0" )"/.. &> /dev/null && pwd )
cd ${SIREUM_HOME}
/bin/bash bin/prelude.sh
SIREUM_JAR=${SIREUM_HOME}/bin/sireum.jar
SIREUM_VERSION=$( git log -n 1 --pretty=format:"%H" )
grep -q ${SIREUM_VERSION} bin/VER &> /dev/null && SIREUM_UPDATE=false || SIREUM_UPDATE=true
SBT=bin/sbt-launch.sh
if [ "${SIREUM_SKIP_BUILD}" != "true" ]; then
  if [ ! -f ${SIREUM_JAR} ]; then
    echo "Please wait while building Sireum; this might take a while..."
    SIREUM_RELEASE=true ${SBT} --error 'set showSuccess := false' clean assembly
    echo
    echo "${SIREUM_VERSION}" > bin/VER
  elif [ "${SIREUM_UPDATE}" = true ]; then
    echo "New changes detected; please wait while re-building Sireum..."
    SIREUM_RELEASE=true ${SBT} --error 'set showSuccess := false' clean assembly
    echo
    echo "${SIREUM_VERSION}" > bin/VER
  else
    CHANGES="$(git status -s)"
    if [[ "${CHANGES}" == *.scala* ]] || [[ "${CHANGES}" == *.java* ]] || [[ "${CHANGES}" == *.stg* ]]; then
      echo "Local source changes detected; please wait while re-building Sireum..."
      SIREUM_RELEASE=true ${SBT} --error 'set showSuccess := false' clean assembly
      echo
      echo "${SIREUM_VERSION}" > bin/VER
    fi
  fi
fi
