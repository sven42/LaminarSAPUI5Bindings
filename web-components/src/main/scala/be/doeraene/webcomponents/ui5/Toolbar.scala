package be.doeraene.webcomponents.ui5

import be.doeraene.webcomponents.ui5.eventtypes.HasDetail
import be.doeraene.webcomponents.ui5.internal.Slot
import com.raquo.laminar.codecs.{BooleanAsAttrPresenceCodec, StringAsIsCodec}
import com.raquo.laminar.api.L.*
import com.raquo.laminar.tags.HtmlTag
import com.raquo.laminar.keys.HtmlAttr
import com.raquo.laminar.nodes.ReactiveHtmlElement
import org.scalajs.dom

import scala.compiletime.ops.int.<=
import scala.concurrent.duration.FiniteDuration
import scala.scalajs.js
import scala.scalajs.js.annotation.JSImport
import be.doeraene.webcomponents.WebComponent
import be.doeraene.webcomponents.ui5.configkeys.{TableColumnPopinDisplay, ToolbarAlign}

object Toolbar extends WebComponent {

  @js.native
  trait RawElement extends js.Object {}

  @js.native
  @JSImport("@ui5/webcomponents/dist/Toolbar.js", JSImport.Default)
  object RawImport extends js.Object

  // object-s are lazy so you need to actually use them in your code to prevent dead code elimination
  used(RawImport)

  type Ref = dom.html.Element with RawElement

  protected val tag: HtmlTag[Ref] = htmlTag("ui5-toolbar")

  lazy val accessibleName: HtmlAttr[String]     = htmlAttr("accessible-name", StringAsIsCodec)
  lazy val accessibleNameRef: HtmlAttr[String]  = htmlAttr("accessible-name-ref", StringAsIsCodec)
  lazy val alignContent: HtmlAttr[ToolbarAlign] = htmlAttr("align-content", ToolbarAlign.AsStringCodec)

  object slots {}

  object events {}

  def button: ToolbarButton.type       = ToolbarButton
  def select: ToolbarSelect.type       = ToolbarSelect
  def separator: ToolbarSeparator.type = ToolbarSeparator
  def spacer: ToolbarSpacer.type       = ToolbarSpacer

}
